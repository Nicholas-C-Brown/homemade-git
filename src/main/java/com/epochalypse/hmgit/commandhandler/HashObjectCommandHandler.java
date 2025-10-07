package com.epochalypse.hmgit.commandhandler;

import com.epochalypse.hmgit.filehandler.FileHandler;
import com.epochalypse.hmgit.sha1service.SHA1Service;
import com.epochalypse.hmgit.zipservice.ZipService;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashObjectCommandHandler extends CommandHandler {

    public static final String COMMAND_NAME = "hash-object";

    private final Logger logger = Logger.getLogger( getClass().getName() );

    private final FileHandler fileHandler;
    private final ZipService zipService;
    private final SHA1Service sha1Service;

    HashObjectCommandHandler( @Nonnull String[] args,
                              @Nonnull FileHandler fileHandler,
                              @Nonnull ZipService zipService,
                              @Nonnull SHA1Service sha1Service ) {
        super( args );
        this.fileHandler = fileHandler;
        this.zipService = zipService;
        this.sha1Service = sha1Service;
    }

    @Override
    public void handleCommand() {
        //For now, assume that the file name is the argument at index 2
        File inputFile = new File( args[2] );
        if ( !fileHandler.fileExists( inputFile ) ) {
            logger.log( Level.WARNING, "File does not exist: " + inputFile.getPath() );
            return;
        }

        //Get input file contents
        String contents;
        try {
            contents = new String( fileHandler.read( inputFile ) );
        } catch ( IOException e ) {
            logger.log( Level.SEVERE, "Error reading file: " + inputFile.getPath(), e );
            return;
        }

        //Blob object format 'blob <size>\0<content>'
        byte[] blob = ( "blob " + contents.length() + "\0" + contents ).getBytes();

        //Calculate the SHA-1 hash of the blob
        String hash;
        try {
            hash = sha1Service.calculateSHA1Hash( blob );
        } catch ( NoSuchAlgorithmException e ) {
            logger.log( Level.SEVERE, "Error hashing file contents: " + inputFile.getPath(), e );
            return;
        }

        //Compress the blob
        byte[] compressedData;
        try {
            compressedData = zipService.compress( blob );
        } catch ( IOException e ) {
            logger.log( Level.SEVERE, "Error compressing file contents: " + inputFile.getPath(), e );
            return;
        }

        //Write the compressed blob to hash file
        File hashFile = getObjectFileFromHash( hash );
        try {
            fileHandler.createAndWrite( hashFile, compressedData );
        } catch ( Exception e ) {
            logger.log( Level.SEVERE, "Error writing hash file: " + hashFile.getPath(), e );
            return;
        }

        System.out.println( hash );
    }
}
