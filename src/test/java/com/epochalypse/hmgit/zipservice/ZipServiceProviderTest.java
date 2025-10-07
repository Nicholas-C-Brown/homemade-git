package com.epochalypse.hmgit.zipservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ZipServiceProviderTest {

    @Test
    void testGetInstance() {
        ZipService zipService1 = ZipServiceProvider.getInstance();
        ZipService zipService2 = ZipServiceProvider.getInstance();

        Assertions.assertNotNull( zipService1 );
        Assertions.assertNotNull( zipService2 );
        Assertions.assertEquals( zipService1, zipService2 );
    }

}
