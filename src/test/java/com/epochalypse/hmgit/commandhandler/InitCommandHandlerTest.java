package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.MockFileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InitCommandHandlerTest extends CommandHandlerTest {

    private final String[] testArgs = new String[]{ InitCommandHandler.COMMAND_NAME };

    @Test
    void testHandleCommand_Success() {
        CommandHandler underTest = new InitCommandHandler(
                testArgs,
                new MockFileHandler( false )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.contains( "Initialized git directory" ) );
    }

    @Test
    void testHandleCommand_HandleAlreadyInitialized() {
        CommandHandler underTest = new InitCommandHandler(
                testArgs,
                new MockFileHandler( true )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

    @Test
    void testHandleCommand_HandleIOException() {
        CommandHandler underTest = new InitCommandHandler(
                testArgs,
                new MockFileHandler(
                        true,
                        true,
                        true )
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.isEmpty() );
    }

}
