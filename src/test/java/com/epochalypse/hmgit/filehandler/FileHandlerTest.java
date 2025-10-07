package com.epochalypse.hmgit.filehandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileHandlerTest {

    private FileHandler underTest;

    @TempDir
    private Path tempDir;

    private File testTextFile;
    private File testDirectory;

    @BeforeEach
    void setUp() {
        underTest = new FileHandlerImpl();

        testTextFile = new File( tempDir.toFile(), "testTextFile.txt" );
        testDirectory = new File( tempDir.toFile(), "testDirectory/subdirectory" );
    }

    @Test
    void testFileExists() {
        Assertions.assertTrue( underTest.fileExists( tempDir.toFile() ) );
        Assertions.assertFalse( underTest.fileExists( testTextFile ) );
        Assertions.assertFalse( underTest.fileExists( testDirectory ) );
    }

    @Test
    void testCreateDirectories() {
        Assertions.assertDoesNotThrow( () -> underTest.createDirectories( testDirectory ) );
        Assertions.assertTrue( testDirectory.exists() );
    }

    @Test
    void testReadFile() throws IOException {
        String writeString = "test";
        Files.writeString( testTextFile.toPath(), writeString );

        byte[] readBytes = underTest.read( testTextFile );
        String readString = new String( readBytes );

        Assertions.assertEquals( writeString, readString );
    }

    @Test
    void testCreateAndWriteFile_String() throws IOException {
        String writeString = "test";
        underTest.createAndWrite( testTextFile, writeString );

        Assertions.assertTrue( testTextFile.exists() );

        String readString = Files.readString( testTextFile.toPath() );
        Assertions.assertEquals( writeString, readString );
    }

    @Test
    void testCreateAndWriteFile_ByteArray() throws IOException {
        byte[] writeBytes = "test".getBytes();
        underTest.createAndWrite( testTextFile, writeBytes );

        Assertions.assertTrue( testTextFile.exists() );

        byte[] readBytes = Files.readAllBytes( testTextFile.toPath() );
        Assertions.assertArrayEquals( writeBytes, readBytes );
    }


}
