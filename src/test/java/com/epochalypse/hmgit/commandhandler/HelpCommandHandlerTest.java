package com.epochalypse.hmgit.commandhandler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelpCommandHandlerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut( new PrintStream( outContent ) );
    }

    @AfterEach
    void tearDown() {
        System.setOut( originalOut );
    }

    @Test
    void testHandleCommand() {
        String[] args = new String[]{ HelpCommandHandler.COMMAND_NAME };
        HelpCommandHandler helpCommandHandler = new HelpCommandHandler( args );
        helpCommandHandler.handleCommand();

        String output = outContent.toString().trim();
        Assertions.assertEquals( "Help command run!", output );
    }

}
