package com.epochalypse.hmgit.filehandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileHandlerProviderTest {

    @Test
    void testGetInstance() {
        FileHandler fileHandler1 = FileHandlerProvider.getInstance();
        FileHandler fileHandler2 = FileHandlerProvider.getInstance();

        Assertions.assertNotNull( fileHandler1 );
        Assertions.assertNotNull( fileHandler2 );
        Assertions.assertEquals( fileHandler1, fileHandler2 );
    }

}
