package oop.ica.part2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YoFishManager {
    // List of YoFish items and associated images for display and management
    private List<YoFishItem> yoFishList = new ArrayList<>();
    private List<BufferedImage> imageList = new ArrayList<>();

    // Data handling configurations
    private static final String DELIMITER = ",";            // Delimiter for data parsing
    private static final String OUTPUT_FILE_PATH = "Output.txt";  // File path for saving output data

    // Table configuration and model setup
    private YoFishTableModel model;                         // Model for managing table data
    private final String[] columnNames = {"ID", "ITEM", "PRICE", "STOCK", "MAX SIZE", "LOW TEMP", "HIGH TEMP"}; // Column headers

    // File paths and directory configurations
    private static final String CWD = System.getProperty("user.dir");           // Current working directory path
    private static final String YOFISH_INPUT_FILE_PATH = CWD + "/yo-fish.txt";  // YoFish input file path
    private static final String PONDLIFE_INPUT_FILE_PATH = CWD + "/pondlife.txt"; // PondLife input file path

  
    
    /**
     * Initializes data by loading YoFish and Pondlife from their respective files.
     * 
     * @return true if data loaded successfully, false if yoFishList is empty after loading.
     * @throws IOException if there is an error loading data from files.
     */
    public boolean initData() throws IOException {
        loadData(YOFISH_INPUT_FILE_PATH, "yo-fish");
        loadData(PONDLIFE_INPUT_FILE_PATH, "pondlife");
        
        return yoFishList.isEmpty() ? false: true;
    }

    /**
     * Loads data from a specified file path and populates the yoFishList accordingly.
     *
     * @param filePath The path of the input file
     * @param name     The name indicating the type of data to load
     * @throws IOException if an I/O error occurs while reading the file
     */
    private void loadData(String filePath, String name) throws IOException {
        File inputFile = new File(filePath);
        
        // Check if the input file exists and is a regular file
        if (!inputFile.exists() || !inputFile.isFile()) {
            JOptionPane.showMessageDialog(null, "!!! File Error: Input file not found: " + inputFile, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        try (Scanner fileScanner = new Scanner(inputFile)) {
            // Read each line from the file and parse the data
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                
                // Check if the line is not empty
                if (!line.isEmpty()) {
                    String[] loadedFields = line.split(DELIMITER);
                    addItemToList(name, loadedFields);
                }
            }
        } 
    }

    /**
     * Adds a YoFishItem or PondLifeItem to the yoFishList based on the provided data fields.
     *
     * @param name The name indicating the type of data
     * @param loadedFields The array of strings containing parsed data fields
     */
    private void addItemToList(String name, String[] loadedFields) {
        if (name.equals("yo-fish")) {
            // Parse YoFish data fields
            int id = Integer.parseInt(loadedFields[0]);
            String itemName = loadedFields[1];
            double price = Double.parseDouble(loadedFields[2]);
            int stock = Integer.parseInt(loadedFields[3]);
            double maxSize = Double.parseDouble(loadedFields[4]);
            int lowTemp = Integer.parseInt(loadedFields[5]);
            int highTemp = Integer.parseInt(loadedFields[6]);

            // Create YoFishItem and add to the list
            yoFishList.add(new YoFishItem(id, itemName, price, stock, maxSize, lowTemp, highTemp));
        } else {
            // Parse PondLife data fields
            int skuNumber = Integer.parseInt(loadedFields[0]);
            String product = loadedFields[1];
            double cost = Double.parseDouble(loadedFields[6]);
            int stock = Integer.parseInt(loadedFields[7]);
            double maxLength = Double.parseDouble(loadedFields[3]);
            int minTemp = Integer.parseInt(loadedFields[4]);
            int maxTemp = Integer.parseInt(loadedFields[5]);

            // Create PondLifeItem and add to the list (assuming you have a similar class)
            yoFishList.add(new YoFishItem(skuNumber, product, cost, stock, maxLength, minTemp, maxTemp)); // Adjust if there's a different class for PondLife
        }
    }


    /*
    * Method: loadImages
    * Description: This method loads images for each YoFishItem in the provided list.
    * It iterates through the list, constructs the file path for each image using the
    * image filename obtained from the YoFishItem object, attempts to read the image
    * using ImageIO, and adds the loaded image to the imageList.
    */
    public void loadImages() {
        // Loop through the provided YoFishItem list
        for (YoFishItem yoFish : yoFishList) {
            // Get the filename and create the relative filepath
            String filepath = "pics/" + yoFish.getImageFilename();

            // Create a BufferedImage object and set to null
            BufferedImage image = null;

            // Attempt to load the image; if an error occurs, it's not critical
            // so no need to exit the application
            try {
                // Read the image file
                image = ImageIO.read(new File(filepath));
            } catch (IOException e) {
                // Warn the user via output (you might want to use logging instead)
                System.err.println("\n\n!!!!! Image Loading Error: " + yoFish.getImageFilename() + " !!!!!\n");
            } finally {
                // Add the BufferedImage to the provided list of images
                imageList.add(image);
            }
        }
    }


    /** 
     * Saves data related to YoFish items to a file named "Output.txt".
     * This method constructs a report containing information about each YoFish item,
     * separated by a delimiter, and writes it to the specified output file. 
     * If the file already exists, it is deleted first.
     * After writing the data, a confirmation message is displayed, including 
     * the absolute path of the file where the data was saved.
     *
     * @throws IOException if an I/O error occurs during file operations
     */
    public void saveData() throws IOException {
        // Define the file path for the output file
        Path path = Paths.get(OUTPUT_FILE_PATH);

        // Delete the file if it already exists
        Files.deleteIfExists(path);

        // Open a buffered output stream to the file
        try (BufferedOutputStream outputToFile = new BufferedOutputStream(Files.newOutputStream(path, CREATE, WRITE))) {
            // Write the report data to the file
            outputToFile.write(constructReport().getBytes());
        }

        // Print a confirmation message with the path of the saved file
        showConfirmationMessage(path.toAbsolutePath());
    }

    /**
     * Constructs a report containing the details of all YoFish items.
     *
     * @return A String representation of the report, with each item's details separated by a delimiter.
     */
    private String constructReport() {
        StringBuilder report = new StringBuilder();

        for (YoFishItem yoFishItem : yoFishList) {
            report.append(yoFishItem.getId()).append(DELIMITER)
                .append(yoFishItem.getItemName()).append(DELIMITER)
                .append(yoFishItem.getPrice()).append(DELIMITER)
                .append(yoFishItem.getStock()).append(DELIMITER)
                .append(yoFishItem.getMaxSize()).append(DELIMITER)
                .append(yoFishItem.getLowTemp()).append(DELIMITER)
                .append(yoFishItem.getHighTemp()).append(System.lineSeparator()); // Using lineSeparator for OS compatibility
        }

        return report.toString();
    }

    /**
     * Displays a confirmation message with the specified file path.
     *
     * @param filePath The absolute path of the file where data was saved.
     */
    private void showConfirmationMessage(Path filePath) {
        JOptionPane.showMessageDialog(
            null,
            "Data written to file at " + filePath
        );
    }

    /**
     * Buys a specified quantity of the selected item from the stock.
     * 
     * @param buyQuantity the quantity to be bought
     */
    public void buyItem(int buyQuantity, int yoFishTableIndex) {
        // Retrieve the currently selected YoFish item
        YoFishItem selectedItem = yoFishList.get(yoFishTableIndex);

        // Calculate new stock quantity after purchase
        int newStock = selectedItem.getStock() - buyQuantity;

        // Update the stock quantity for the selected item
        selectedItem.setStock(newStock);

        // Display purchase information to the user
        showPurchaseConfirmation(selectedItem, buyQuantity, newStock);

        // Update the stock quantity in the table model
        model.setValueAt(newStock, yoFishTableIndex, 3);

        
    }

    /**
     * Displays a confirmation dialog with the purchase details.
     *
     * @param item        the YoFishItem that was purchased
     * @param quantity    the quantity bought
     * @param remainingStock the stock remaining after the purchase
     */
    private void showPurchaseConfirmation(YoFishItem item, int quantity, int remainingStock) {
        JOptionPane.showMessageDialog(null, 
                "Item: " + item.getItemName() +
                "\nPrice: " + item.getFormattedPrice() +
                "\nUnits bought: " + quantity +
                "\nStock remaining: " + remainingStock
        );
    }

    
    /**
    * Adds stock quantity to the selected item in the table.
    *
    * @param addQuantity the quantity to be added to the stock
    */
    public int addStock(int addQuantity, int yoFishTableIndex){
        // Calculate new stock quantity
        int newStock = yoFishList.get(yoFishTableIndex).getStock() + addQuantity;

        // Update stock quantity for the selected item
        yoFishList.get(yoFishTableIndex).setStock(newStock);

        return newStock;
    
    }



    /**
     * Retrieves the item name of the currently selected YoFish table row.
     * 
     * @return the item name of the selected YoFish item.
     */
    public String getCurrentItemName(int index) {
        return yoFishList.get(index).getItemName();
    }

    /**
     * Retrieves the stock size of the currently selected YoFish table row.
     * 
     * @return the stock size of the selected YoFish item.
     */
    public int getCurrentStockSize(int index) {
        return yoFishList.get(index).getStock();
    }




    /**
     * Sets up the YoFishTableModel with column names and the YoFish item list.
     * Links the table model to the JTable.
     */
    public YoFishTableModel setupTableModel() {
        model = new YoFishTableModel(columnNames, getYoFishList());
        return model;
    }  




    /**
     * Retrieves the image of the current YoFish table row.
     * 
     * @return the BufferedImage for the selected YoFish item.
     */
    public BufferedImage getCurrentImage(int index) {
        return imageList.get(index);
    }




    /**
     * Retrieves the list of YoFish items.
     *
     * @return A list containing all YoFish items.
     */
    public List<YoFishItem> getYoFishList() {
        // Return the YoFish item list
        return yoFishList;
    }
}

