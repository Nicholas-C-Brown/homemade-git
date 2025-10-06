package com.epochalypse.hmgit.commandhandler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class CommandHandlerTest {

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

    protected String getSystemOutput() {
        return outContent.toString().trim();
    }

}
