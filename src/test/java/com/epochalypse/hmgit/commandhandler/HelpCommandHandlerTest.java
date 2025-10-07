package com.epochalypse.hmgit.commandhandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelpCommandHandlerTest extends CommandHandlerTest {

    @Test
    void testHandleCommand() {
        String[] args = new String[]{ HelpCommandHandler.COMMAND_NAME };
        HelpCommandHandler helpCommandHandler = new HelpCommandHandler( args );
        helpCommandHandler.handleCommand();

        String output = getSystemOutput();
        Assertions.assertEquals( "Help command run!", output );
    }

}
