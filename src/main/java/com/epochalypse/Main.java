package com.epochalypse;

import com.epochalypse.hmgit.commandhandler.CommandHandler;
import com.epochalypse.hmgit.commandhandler.CommandHandlerFactory;

public class Main {
    private Main() {
        
    }

    static void main( String[] args ) {
        CommandHandler handler = CommandHandlerFactory.getCommandHandler( args );
        handler.handleCommand();
    }
}
