package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.mocks.FileExistsFileHandlerMock;
import com.epochalypse.hmgit.filehandler.mocks.HappyFileHandlerMock;
import com.epochalypse.hmgit.filehandler.mocks.ThrowExceptionFileHandlerMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitCommandHandlerTest extends CommandHandlerTest {

    @Test
    void testHandleCommand_Success() {
        CommandHandler underTest = new InitCommandHandler(
                new String[]{ InitCommandHandler.COMMAND_NAME },
                new HappyFileHandlerMock()
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
        String output = getSystemOutput();
        Assertions.assertTrue( output.contains( "Initialized git directory" ) );
    }

    @Test
    void testHandleCommand_HandleAlreadyInitialized() {
        CommandHandler underTest = new InitCommandHandler(
                new String[]{ InitCommandHandler.COMMAND_NAME },
                new FileExistsFileHandlerMock()
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
    }

    @Test
    void testHandleCommand_HandleIOException() {
        CommandHandler underTest = new InitCommandHandler(
                new String[]{ InitCommandHandler.COMMAND_NAME },
                new ThrowExceptionFileHandlerMock()
        );

        Assertions.assertDoesNotThrow( underTest::handleCommand );
    }

}
