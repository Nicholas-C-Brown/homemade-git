package com.epochalypse.hmgit.zipservice;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * Service class for interacting with ZLib compressed data
 */
public interface ZipService {

    /**
     * Decompresses a byte[]
     *
     * @param bytes compressed {@code byte[]}
     *
     * @return the decompressed {@code byte[]}
     */
    @Nonnull
    byte[] decompress( @Nonnull byte[] bytes ) throws IOException;

    /**
     * Compresses a {@code byte[]}
     *
     * @param bytes decompressed {@code byte[]}
     *
     * @return the compressed {@code byte[]}
     */
    byte[] compress( @Nonnull byte[] bytes ) throws IOException;

}
