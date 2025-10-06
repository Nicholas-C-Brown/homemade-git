package com.epochalypse.hmgit.filehandler;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;

/**
 * A service for interacting with files
 */
public interface FileHandler {

    /**
     * Determines whether the supplied file exists
     *
     * @param file a file
     *
     * @return {@code true} if the file exists, otherwise {@code false}
     */
    boolean fileExists( File file );

    /**
     * Creates the specified directories
     *
     * @param file a directory
     *
     * @throws IOException if an issue occurs while creating the directories
     */
    void createDirectories( File file ) throws IOException;

    /**
     * Reads the {@code byte[]} contents from a file
     *
     * @param file a file
     *
     * @return the file's {@code byte[]} contents
     *
     * @throws IOException if an issue occurs while reading the file
     */
    byte[] read( @Nonnull File file ) throws IOException;

    /**
     * Writes string contents to a file
     *
     * @param file    a file
     * @param content the string content to write
     *
     * @throws IOException if an issue occurs while writing to the file
     */
    void write( File file, String content ) throws IOException;

    /**
     * Writes {@code byte[]} contents to a file
     *
     * @param file    a file
     * @param content the {@code byte[]} content to write
     *
     * @throws IOException if an issue occurs while writing to the file
     */
    void write( File file, byte[] content ) throws IOException;

}
