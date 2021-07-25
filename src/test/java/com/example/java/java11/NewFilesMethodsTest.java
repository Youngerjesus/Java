package com.example.java.java11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class NewFilesMethodsTest {

    @Test
    void Files_writeString_Method() throws IOException {
        //given
        Path filePath = Files.writeString(Files.createTempFile(Path.of("demo"), "demo", ".txt"), "Sample String");
        //when
        String fileContent = Files.readString(filePath);
        //then
        assertEquals("Sample String", fileContent);
    }
}