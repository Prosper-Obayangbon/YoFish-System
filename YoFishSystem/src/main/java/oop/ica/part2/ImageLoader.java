package oop.ica.part2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The ImageLoader class provides methods to load images from specified file paths.
 */
public class ImageLoader {

    /**
     * Loads an image from the specified file path.
     *
     * @param filepath The path of the image file to load.
     * @return The BufferedImage loaded from the file, or null if an error occurs.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static BufferedImage loadImage(String filepath) {
        try {
            // Attempt to read the image file
            return ImageIO.read(new File(filepath));
        } catch (IOException e) {
            // Log the error and return null
            System.err.println("Image loading error: " + e.getMessage());
            return null; // Returning null indicates the image could not be loaded
        }
    }
}
