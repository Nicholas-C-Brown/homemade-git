package com.epochalypse.hmgit.sha1service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1ServiceImpl implements SHA1Service {

    SHA1ServiceImpl() {

    }

    @Override
    public String calculateSHA1Hash( byte[] blob ) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance( "SHA-1" );
        byte[] digest = messageDigest.digest( blob );
        return bytesToHexString( digest );
    }

    private String bytesToHexString( byte[] bytes ) {
        StringBuilder hexString = new StringBuilder();
        for ( byte b : bytes ) {
            hexString.append( String.format( "%02x", b ) );
        }
        return hexString.toString();
    }


}
