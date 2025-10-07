package com.epochalypse.hmgit.zipservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ZipServiceTest {

    private ZipService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ZipServiceImpl();
    }

    @Test
    void testCompressingAndDecompressedData() throws IOException {
        String expectedString = getLoremIpsum();
        byte[] compressedData = underTest.compress( expectedString.getBytes() );

        //Compressed data should be smaller than uncompressed data
        // (Provided the uncompressed data is big enough)
        int compressedDataLength = compressedData.length;
        int stringDataLength = expectedString.getBytes().length;
        Assertions.assertTrue( compressedDataLength < stringDataLength );

        //Decompressed string should be the same as the original
        byte[] decompressedData = underTest.decompress( compressedData );
        String decomressedString = new String( decompressedData );
        Assertions.assertEquals( expectedString, decomressedString );
    }

    private String getLoremIpsum() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Pellentesque nec mauris est. Sed id felis leo." +
                " Fusce finibus rhoncus lacus, nec ullamcorper ipsum cursus id." +
                " Quisque egestas convallis sapien, ac vestibulum eros." +
                " In sed libero a turpis hendrerit porta." +
                " Aenean quis nisl consequat, lacinia lectus sed, dignissim felis." +
                " Curabitur dignissim id dui vel pellentesque. Cras id est eros." +
                " Nam accumsan facilisis purus, non faucibus felis mattis nec." +
                " Etiam pharetra malesuada orci, ac tempor enim tincidunt a." +
                " Suspendisse finibus est non nunc ornare sollicitudin." +
                " Quisque eros magna, convallis at orci ac, blandit accumsan mauris.";
    }

}
