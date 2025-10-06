package com.epochalypse.hmgit.filehandler.mocks;

import com.epochalypse.hmgit.filehandler.FileHandler;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;

public class ThrowExceptionFileHandlerMock implements FileHandler {

    @Override
    public boolean fileExists( File file ) {
        return false;
    }

    @Override
    public void createDirectories( File file ) throws IOException {
        throw new IOException();
    }

    @Override
    public byte[] read( @Nonnull File file ) {
        return "test".getBytes();
    }

    @Override
    public void write( File file, String content ) throws IOException {
        throw new IOException();
    }

    @Override
    public void write( File file, byte[] content ) throws IOException {
        throw new IOException();
    }

}
