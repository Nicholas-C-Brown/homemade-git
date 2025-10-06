package com.epochalypse.hmgit.filehandler;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class FileHandlerImpl implements FileHandler {

    @Override
    public boolean fileExists( File file ) {
        return Files.exists( file.toPath() );
    }

    @Override
    public void createDirectories( File file ) throws IOException {
        Files.createDirectories( file.toPath() );
    }

    @Override
    public byte[] read( @Nonnull File file ) throws IOException {
        return Files.readAllBytes( file.toPath() );
    }

    @Override
    public void write( File file, String content ) throws IOException {
        write( file, content.getBytes() );
    }

    @Override
    public void write( File file, byte[] content ) throws IOException {
        Files.write( file.toPath(), content );
    }

}
