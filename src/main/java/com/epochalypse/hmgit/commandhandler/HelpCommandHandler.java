package com.epochalypse.hmgit.commandhandler;

import javax.annotation.Nonnull;

public class HelpCommandHandler extends CommandHandler {

    public static final String COMMAND_NAME = "help";

    HelpCommandHandler( @Nonnull String[] args ) {
        super( args );
    }

    @Override
    public void handleCommand() {
        System.out.println( "Help command run!" );
    }
}
