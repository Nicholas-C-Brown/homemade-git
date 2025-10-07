package com.epochalypse.hmgit.sha1service;

import java.security.NoSuchAlgorithmException;

/**
 * Service for calculating SHA-1 hashes
 */
public interface SHA1Service {

    /**
     * Calculates the SHA-1 hash for the supplied blob
     *
     * @param blob the blob object to encode
     *
     * @return the hex string hash of the file
     */
    String calculateSHA1Hash( byte[] blob ) throws NoSuchAlgorithmException;

}
