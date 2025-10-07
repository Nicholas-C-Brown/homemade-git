package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.FileHandler;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A command handler for handling the 'init' command
 */
public class InitCommandHandler extends CommandHandler {

    public static final String COMMAND_NAME = "init";

    private final Logger logger = Logger.getLogger( getClass().getName() );

    private final FileHandler fileHandler;

    /**
     * Creates a new {@link InitCommandHandler} instance
     *
     * @param args        supplied program arguments (Cannot be null)
     * @param fileHandler a {@link FileHandler} instance (Cannot be null)
     */
    InitCommandHandler( @Nonnull String[] args, @Nonnull FileHandler fileHandler ) {
        super( args );
        this.fileHandler = fileHandler;
    }

    @Override
    public void handleCommand() {
        try {
            File root = new File( ROOT );

            if ( fileHandler.fileExists( root ) ) {
                logger.log( Level.WARNING, "A gud repository has already been initialized in this directory" );
                return;
            }

            File objects = new File( root, OBJECTS );
            File refs = new File( root, REFS );
            fileHandler.createDirectories( objects );
            fileHandler.createDirectories( refs );

            File head = new File( root, "HEAD" );
            fileHandler.createAndWrite( head, "ref: refs/heads/main\n" );

            System.out.println( "Initialized git directory" );

        } catch ( IOException e ) {
            logger.log( Level.SEVERE, "Error initializing git repository", e );
        }
    }
}
