package com.epochalypse.hmgit.commandhandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandHandlerFactoryTest {

    @Test
    void testGetCommandHandler_HelpCommandHandler() {
        String[] args = { HelpCommandHandler.COMMAND_NAME };
        CommandHandler handler = CommandHandlerFactory.getCommandHandler( args );

        Assertions.assertEquals( HelpCommandHandler.class, handler.getClass() );
    }

}
