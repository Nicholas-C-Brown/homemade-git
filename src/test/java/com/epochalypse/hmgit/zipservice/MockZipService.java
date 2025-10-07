package com.epochalypse.hmgit.zipservice;

import javax.annotation.Nonnull;
import java.io.IOException;

public class MockZipService implements ZipService {

    private final byte[] decompressedBytes;
    private final byte[] compressedBytes;
    private final boolean throwExceptionOnDecompress;
    private final boolean throwExceptionOnCompress;

    /**
     * Creates a new {@link MockZipService} that does nothing fancy
     */
    public MockZipService() {
        this( new byte[0], new byte[0], false, false );
    }

    /**
     * Creates a new {@link MockZipService} that does not throw any exceptions
     *
     * @param decompressedBytes bytes to return on {@code decompress} method call
     * @param compressedBytes   bytes to return on {@code compress} method call
     */
    public MockZipService( byte[] decompressedBytes, byte[] compressedBytes ) {
        this( decompressedBytes, compressedBytes, false, false );
    }

    /**
     * Creates a new {@link MockZipService} that throws exceptions when specified
     *
     * @param throwExceptionOnDecompress throw an exception on {@code decompress} method call
     * @param throwExceptionOnCompress   throw an exception on {@code compress} method call
     */
    public MockZipService( boolean throwExceptionOnDecompress,
                           boolean throwExceptionOnCompress ) {
        this( new byte[0], new byte[0], throwExceptionOnDecompress, throwExceptionOnCompress );
    }

    /**
     * Creates a new {@link MockZipService}
     *
     * @param decompressedBytes          bytes to return on {@code decompress} method call
     * @param compressedBytes            bytes to return on {@code compress} method call
     * @param throwExceptionOnDecompress throw an exception on {@code decompress} method call
     * @param throwExceptionOnCompress   throw an exception on {@code compress} method call
     */
    public MockZipService( byte[] decompressedBytes,
                           byte[] compressedBytes,
                           boolean throwExceptionOnDecompress,
                           boolean throwExceptionOnCompress ) {
        this.decompressedBytes = decompressedBytes;
        this.compressedBytes = compressedBytes;
        this.throwExceptionOnDecompress = throwExceptionOnDecompress;
        this.throwExceptionOnCompress = throwExceptionOnCompress;
    }

    @Nonnull
    @Override
    public byte[] decompress( @Nonnull byte[] bytes ) throws IOException {
        if ( throwExceptionOnDecompress ) {
            throw new IOException( "decompress exception" );
        }
        return decompressedBytes;
    }

    @Override
    public byte[] compress( @Nonnull byte[] bytes ) throws IOException {
        if ( throwExceptionOnCompress ) {
            throw new IOException( "compress exception" );
        }
        return compressedBytes;
    }
}
