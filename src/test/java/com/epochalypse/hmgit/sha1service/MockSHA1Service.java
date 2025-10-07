package com.epochalypse.hmgit.sha1service;

import java.security.NoSuchAlgorithmException;

public class MockSHA1Service implements SHA1Service {

    private final String hash;
    private final boolean throwException;

    /**
     * Creates a new {@link MockSHA1Service} that throws an exception
     */
    public MockSHA1Service() {
        this.hash = "";
        this.throwException = true;
    }

    /**
     * Creates a new {@link MockSHA1Service} that returns the supplied string
     *
     * @param hash mock hash string
     */
    public MockSHA1Service( String hash ) {
        this.hash = hash;
        this.throwException = false;
    }


    @Override
    public String calculateSHA1Hash( byte[] blob ) throws NoSuchAlgorithmException {
        if ( throwException ) {
            throw new NoSuchAlgorithmException( "calculateSHA1Hash exception" );
        }
        return hash;
    }
}
