package oop.ica.part2;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Utility class for file operations, specifically for saving data to a specified file.
 */
public class DataManager {

    /**
     * Saves data to a specified file, overwriting it if it already exists.
     * Deletes the file if it exists, then writes the provided data to it.
     * 
     * @param path  the file path where data should be saved
     * @param data  the byte array of data to write to the file
     * @throws IOException if an I/O error occurs during file operations
     */
    public static void saveToFile(Path path, byte[] data) throws IOException {
        // Delete the file if it already exists to ensure a clean write
        Files.deleteIfExists(path);
        
        // Write data to file using a buffered output stream for efficiency
        try (BufferedOutputStream outputToFile = new BufferedOutputStream(Files.newOutputStream(path))) {
            outputToFile.write(data, 0, data.length);
        }
    }
}


