package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.MockFileHandler;
import com.epochalypse.hmgit.sha1service.MockSHA1Service;
import com.epochalypse.hmgit.zipservice.MockZipService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashObjectCommandHandlerTest extends CommandHandlerTest {

    private final String[] testArgs = new String[]{ HashObjectCommandHandler.COMMAND_NAME, "-w", "testFile.txt" };
    private final String testHash = "testHash";

    @Test
    void testHandleCommand_Success() {
        CommandHandler underTest = new HashObjectCommandHandler(
                testArgs,
                new MockFileHandler( true ),
                new MockZipService(),
                new MockSHA1Service( testHash )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );

        String output = getSystemOutput();
        Assertions.assertTrue( output.contains( testHash ) );
    }

    @Test
    void testHandleCommand_FileDoesNotExist() {
        CommandHandler underTest = new HashObjectCommandHandler(
                testArgs,
                new MockFileHandler( false ),
                new MockZipService(),
                new MockSHA1Service( testHash )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_ExceptionOnReadingFile() {
        CommandHandler underTest = new HashObjectCommandHandler(
                testArgs,
                new MockFileHandler( false, true, false ),
                new MockZipService(),
                new MockSHA1Service( testHash )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_ExceptionOnCalculatingHash() {
        CommandHandler underTest = new HashObjectCommandHandler(
                testArgs,
                new MockFileHandler( true ),
                new MockZipService(),
                new MockSHA1Service()
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_ExceptionOnCompressingBlob() {
        CommandHandler underTest = new HashObjectCommandHandler(
                testArgs,
                new MockFileHandler( true ),
                new MockZipService( false, true ),
                new MockSHA1Service( testHash )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_ExceptionOnWritingFile() {
        CommandHandler underTest = new HashObjectCommandHandler(
                testArgs,
                new MockFileHandler( false, false, true ),
                new MockZipService(),
                new MockSHA1Service( testHash )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

}
