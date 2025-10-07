package com.epochalypse.hmgit.commandhandler;

import javax.annotation.Nonnull;
import java.io.File;
import java.nio.file.Path;

/**
 * Abstract Command Handler implementation.
 * All CommandHandlers should extend this class.
 */
public abstract class CommandHandler {

    protected static final String ROOT = ".gud";
    protected static final String OBJECTS = "objects";
    protected static final String REFS = "refs";

    protected final String[] args;

    /**
     * Creates a new {@link CommandHandler} instance
     *
     * @param args supplied program arguments (Cannot be null)
     */
    CommandHandler( @Nonnull String[] args ) {
        this.args = args;
    }

    /**
     * Executes the command.
     * </p>
     * Outputs success or failure status to the console.
     */
    public abstract void handleCommand();

    //TODO Move to its own service
    protected File getObjectFileFromHash( String hash ) {
        //First two characters of the hash are the directory name
        String directory = hash.substring( 0, 2 );

        //Remaining characters are the file name
        String fileName = hash.substring( 2 );

        Path path = Path.of( ROOT, OBJECTS, directory, fileName );
        return new File( path.toUri() );
    }

}
