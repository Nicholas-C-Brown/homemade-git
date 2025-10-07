package com.epochalypse.hmgit.sha1service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class SHA1ServiceTest {

    @Test
    void testCalculateSHA1Hash() throws NoSuchAlgorithmException {

        SHA1Service underTest = new SHA1ServiceImpl();

        byte[] testBlob = "blob 12\0hello world!".getBytes();
        String expectedHash = "bc7774a7b18deb1d7bd0212d34246a9b1260ae17";
        String actualHash = underTest.calculateSHA1Hash( testBlob );
        Assertions.assertEquals( expectedHash, actualHash );

    }

}
