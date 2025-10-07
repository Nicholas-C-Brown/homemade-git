package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.MockFileHandler;
import com.epochalypse.hmgit.zipservice.MockZipService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CatFileCommandHandlerTest extends CommandHandlerTest {

    private final String[] testArgs = new String[]{ CatFileCommandHandler.COMMAND_NAME, "-p", "test" };

    @Test
    void testHandleCommand_Success() {
        String expected = "test";
        byte[] decompressedBytes = ( "blob " + expected.length() + "\0" + expected ).getBytes();

        CommandHandler underTest = new CatFileCommandHandler(
                testArgs,
                new MockFileHandler( true ),
                new MockZipService( decompressedBytes, new byte[0] )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );

        String output = getSystemOutput();
        Assertions.assertTrue( output.contains( expected ) );
    }

    @Test
    void testHandleCommand_FileDoesNotExist() {
        CommandHandler underTest = new CatFileCommandHandler(
                testArgs,
                new MockFileHandler( false ),
                new MockZipService()
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_ExceptionReadingFile() {
        CommandHandler underTest = new CatFileCommandHandler(
                testArgs,
                new MockFileHandler(
                        false,
                        true,
                        false ),
                new MockZipService()
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_ExceptionDecompressingFile() {
        CommandHandler underTest = new CatFileCommandHandler(
                testArgs,
                new MockFileHandler( true ),
                new MockZipService( true, false )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

}
