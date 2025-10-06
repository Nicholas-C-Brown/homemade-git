package com.epochalypse.hmgit.filehandler.mocks;

import com.epochalypse.hmgit.filehandler.FileHandler;

import javax.annotation.Nonnull;
import java.io.File;

public class HappyFileHandlerMock implements FileHandler {

    @Override
    public boolean fileExists( File file ) {
        return false;
    }

    @Override
    public void createDirectories( File file ) {
        
    }

    @Override
    public byte[] read( @Nonnull File file ) {
        return "test".getBytes();
    }

    @Override
    public void write( File file, String content ) {

    }

    @Override
    public void write( File file, byte[] content ) {

    }

}
