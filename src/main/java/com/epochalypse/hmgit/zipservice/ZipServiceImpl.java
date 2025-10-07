package com.epochalypse.hmgit.zipservice;

import javax.annotation.Nonnull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.DeflaterInputStream;
import java.util.zip.InflaterInputStream;

class ZipServiceImpl implements ZipService {

    ZipServiceImpl() {

    }

    @Nonnull
    @Override
    public byte[] decompress( @Nonnull byte[] bytes ) throws IOException {
        try ( ByteArrayInputStream byteStream = new ByteArrayInputStream( bytes );
              InflaterInputStream iis = new InflaterInputStream( byteStream ) ) {
            return iis.readAllBytes();
        }
    }

    @Override
    public byte[] compress( @Nonnull byte[] bytes ) throws IOException {
        try ( ByteArrayInputStream byteStream = new ByteArrayInputStream( bytes );
              DeflaterInputStream dis = new DeflaterInputStream( byteStream ) ) {
            return dis.readAllBytes();
        }


    }

}
