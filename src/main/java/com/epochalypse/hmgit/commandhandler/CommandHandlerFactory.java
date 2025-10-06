package com.epochalypse.hmgit.commandhandler;

public class CommandHandlerFactory {

    private CommandHandlerFactory() {
        throw new UnsupportedOperationException( "Static factory class should not be instantiated." );
    }

    public static CommandHandler getCommandHandler( String[] args ) {
        return new HelpCommandHandler( args );
    }

}
