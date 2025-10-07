package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.FileHandler;
import com.epochalypse.hmgit.zipservice.ZipService;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatFileCommandHandler extends CommandHandler {

    public static final String COMMAND_NAME = "cat-file";

    private final Logger logger = Logger.getLogger( getClass().getName() );

    private final FileHandler fileHandler;
    private final ZipService zipService;

    /**
     * Creates a new {@link CatFileCommandHandler} instance
     *
     * @param args        supplied program arguments (Cannot be null)
     * @param fileHandler a {@link FileHandler} instance (Cannot be null)
     * @param zipService  a {@link ZipService} instance (Cannot be null)
     */
    CatFileCommandHandler(
            @Nonnull String[] args,
            @Nonnull FileHandler fileHandler,
            @Nonnull ZipService zipService
    ) {
        super( args );
        this.fileHandler = fileHandler;
        this.zipService = zipService;
    }

    @Override
    public void handleCommand() {
        //For now, assume that the hash is the argument at index 2
        String hash = args[2];
        File hashFile = getObjectFileFromHash( hash );

        if ( !fileHandler.fileExists( hashFile ) ) {
            logger.log( Level.WARNING, "Hash file not found: " + hashFile.getPath() );
            return;
        }

        byte[] compressedData;
        try {
            compressedData = fileHandler.read( hashFile );
        } catch ( IOException e ) {
            logger.log( Level.SEVERE, "Error reading hash file: " + hashFile.getPath(), e );
            return;
        }

        try {
            String decompressedData = new String( zipService.decompress( compressedData ) );
            String delimiter = "\0";
            String fileContents = decompressedData.split( delimiter )[1];
            System.out.print( fileContents );
        } catch ( Exception e ) {
            logger.log( Level.SEVERE, "Error decompressing hash file contents: " + hashFile.getPath(), e );
        }
    }

}
