package com.epochalypse.hmgit.filehandler;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;

public class MockFileHandler implements FileHandler {

    private final boolean fileExists;
    private final byte[] readBytes;
    private final boolean throwExceptionOnCreateDirectories;
    private final boolean throwExceptionOnRead;
    private final boolean throwExceptionOnWrite;

    /**
     * Creates a new {@link MockFileHandler} that does not throw any exceptions
     *
     * @param fileExists boolean to return on {@code fileExists} method call
     */
    public MockFileHandler( boolean fileExists ) {
        this( fileExists,
                new byte[0],
                false,
                false,
                false );
    }

    /**
     * Creates a new {@link MockFileHandler} that says a file exists and returns a value when a file is read
     *
     * @param readBytes {@code byte[])} to return on {@code read} method call
     */
    public MockFileHandler( byte[] readBytes ) {
        this( true,
                readBytes,
                false,
                false,
                false );
    }

    /**
     * Creates a new {@link MockFileHandler} that says a file exists and throws exceptions when specified
     *
     * @param throwExceptionOnCreateDirectories throw an exception on {@code createDirectories} method call
     * @param throwExceptionOnRead              throw an exception on {@code read} method call
     * @param throwExceptionOnWrite             throw an exception on {@code createAndWrite} method calls
     */
    public MockFileHandler( boolean throwExceptionOnCreateDirectories,
                            boolean throwExceptionOnRead,
                            boolean throwExceptionOnWrite ) {
        this( true,
                new byte[0],
                throwExceptionOnCreateDirectories,
                throwExceptionOnRead,
                throwExceptionOnWrite );
    }

    /**
     * Creates a new {@link MockFileHandler}
     *
     * @param fileExists                        boolean to return on {@code fileExists} method call
     * @param readBytes                         {@code byte[])} to return on {@code read} method call
     * @param throwExceptionOnCreateDirectories throw an exception on {@code createDirectories} method call
     * @param throwExceptionOnRead              throw an exception on {@code read} method call
     * @param throwExceptionOnWrite             throw an exception on {@code createAndWrite} method calls
     */
    public MockFileHandler( boolean fileExists,
                            byte[] readBytes,
                            boolean throwExceptionOnCreateDirectories,
                            boolean throwExceptionOnRead,
                            boolean throwExceptionOnWrite ) {
        this.fileExists = fileExists;
        this.readBytes = readBytes;
        this.throwExceptionOnCreateDirectories = throwExceptionOnCreateDirectories;
        this.throwExceptionOnRead = throwExceptionOnRead;
        this.throwExceptionOnWrite = throwExceptionOnWrite;
    }


    @Override
    public boolean fileExists( File file ) {
        return fileExists;
    }

    @Override
    public void createDirectories( File file ) throws IOException {
        if ( throwExceptionOnCreateDirectories ) {
            throw new IOException( "createDirectories exception" );
        }
    }

    @Override
    public byte[] read( @Nonnull File file ) throws IOException {
        if ( throwExceptionOnRead ) {
            throw new IOException( "read exception" );
        }
        return readBytes;
    }

    @Override
    public void createAndWrite( File file, String content ) throws IOException {
        if ( throwExceptionOnWrite ) {
            throw new IOException( "createAndWrite exception" );
        }
    }

    @Override
    public void createAndWrite( File file, byte[] content ) throws IOException {
        if ( throwExceptionOnWrite ) {
            throw new IOException( "createAndWrite exception" );
        }
    }
}
