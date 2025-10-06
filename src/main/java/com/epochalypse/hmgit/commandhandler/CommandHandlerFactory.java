package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.FileHandlerProvider;

import javax.annotation.Nonnull;

/**
 * A Factory that produces a {@link CommandHandler} for the supplied program argument(s)
 */
public class CommandHandlerFactory {

    private CommandHandlerFactory() {
        throw new UnsupportedOperationException( "Static factory class should not be instantiated." );
    }

    /**
     * Instantiates the appropriate command handler for the supplied program argument(s)
     *
     * @param args the program argument(s) (Cannot be null)
     *
     * @return a {@link CommandHandler} to handle the program argument(s) (Is never null)
     */
    @Nonnull
    public static CommandHandler getCommandHandler( @Nonnull String[] args ) {

        if ( args.length == 0 ) {
            return new HelpCommandHandler( args );
        }

        String commandName = args[0];

        return switch ( commandName ) {
            case InitCommandHandler.COMMAND_NAME -> new InitCommandHandler(
                    args,
                    FileHandlerProvider.getInstance()
            );
            default -> new HelpCommandHandler( args );
        };

    }

}
