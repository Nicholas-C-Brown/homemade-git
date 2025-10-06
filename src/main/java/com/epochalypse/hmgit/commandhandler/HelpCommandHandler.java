package com.epochalypse.hmgit.commandhandler;

import javax.annotation.Nonnull;

/**
 * A command handler for handling the 'help' command
 */
public class HelpCommandHandler extends CommandHandler {

    public static final String COMMAND_NAME = "help";

    /**
     * Creates a new {@link HelpCommandHandler} instance
     *
     * @param args supplied program arguments (Cannot be null)
     */
    HelpCommandHandler( @Nonnull String[] args ) {
        super( args );
    }

    @Override
    public void handleCommand() {
        System.out.println( "Help command run!" );
    }
}
