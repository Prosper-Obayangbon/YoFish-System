/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop.ica.part2;

// Import neccessary parkages
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;



/**
 *
 * @author Prosper Nosa Obayangbon 
 * D3424757
 */
public class YoFishGUI extends javax.swing.JFrame {

    YoFishManager yoFishManager = new YoFishManager();



    /**
     * Constructs a YoFishGUI instance.
     * Initializes data, loads images, and sets up GUI components.
     */
    public YoFishGUI() {
        
        // Attempt to initialize data from the YoFishManager
        try {
            if(!yoFishManager.initData()){
                // Show an error message if data initialization fails
                JOptionPane.showMessageDialog(null, "Data Error! No Data Loaded", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); // Terminate the application if no data is loaded

            }
            
        } catch (IOException e) {
            // Handle IOException during data loading and notify the user
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0); // Terminate the application on error
        }
        
        // Load images for the YoFish items
        yoFishManager.loadImages();
        
        // Initialize GUI components
        initComponents();
        
        // Set up the JTable with data
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        itemLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        yoFishTable = new javax.swing.JTable();
        buyButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yo-Fish");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Item Photo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial Black", 0, 12))); // NOI18N

        picLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        picLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        picLabel.setOpaque(true);

        itemLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout picPanelLayout = new javax.swing.GroupLayout(picPanel);
        picPanel.setLayout(picPanelLayout);
        picPanelLayout.setHorizontalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picPanelLayout.createSequentialGroup()
                .addGroup(picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(picPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addGroup(picPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        picPanelLayout.setVerticalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        yoFishTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        yoFishTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yoFishTableMouseClicked(evt);
            }
        });
        yoFishTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yoFishTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yoFishTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(yoFishTable);

        buyButton.setText("Buy");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        quitButton.setBackground(new java.awt.Color(255, 0, 0));
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buyButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(quitButton)
                        .addContainerGap())
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quitButton)
                            .addComponent(addButton)
                            .addComponent(buyButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event handler for key pressed in the YOFish table
    private void yoFishTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yoFishTableKeyPressed
        // Get the index of the selected row in the YoFish table
        yoFishTableIndex = yoFishTable.getSelectedRow();
        
        // Call the view method to handle viewing details of the selected item
        viewSelectedItem(yoFishTableIndex);
    }//GEN-LAST:event_yoFishTableKeyPressed

    // Event handler for key presses in the YoFish table
    private void yoFishTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yoFishTableKeyReleased
        // Get the index of the selected row in the YoFish table
        yoFishTableIndex = yoFishTable.getSelectedRow();
        
        // Call the view method to handle viewing details of the selected item
        viewSelectedItem(yoFishTableIndex);
    }//GEN-LAST:event_yoFishTableKeyReleased

    // Event handler for mouse clicks in the YoFish table
    private void yoFishTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yoFishTableMouseClicked
        // Get the index of the selected row in the YoFish table
        yoFishTableIndex = yoFishTable.getSelectedRow();
        
        // Call the view method to handle viewing details of the selected item
        viewSelectedItem(yoFishTableIndex);
    }//GEN-LAST:event_yoFishTableMouseClicked
    // Call the quit method to handle program termination
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Call the quit method to handle program termination
        quit();
    }//GEN-LAST:event_formWindowClosing

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // Call the quit method to exit the program
        quit();

    }//GEN-LAST:event_quitButtonActionPerformed

    // Action performed when the buy Button is clicked
    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        // Get the selected row index from yoFish Table
        yoFishTableIndex = yoFishTable.getSelectedRow();

        // Check if a row is selected
        if(yoFishTableIndex >= 0){
            // Get the name and stock size of the selected item
            String itemName = yoFishManager.getYoFishList().get(yoFishTableIndex).getItemName();
            int stockSize = yoFishManager.getYoFishList().get(yoFishTableIndex).getStock();

            // Check if the selected item is in stock
            if(stockSize > 0){
                // Create an array to hold integer options for quantity selection
                Integer [] options = new Integer[stockSize];

                // populate the option array with number 1 to stockSize
                for (int num =1; num<=stockSize; num++){
                    options[num - 1] = num;
                }

                // Display an input dialog to select the quantity of the item to buy
                Object inputValue = JOptionPane.showInputDialog(
                    null,
                    "Please select the quantity of "
                    + itemName + " you wish to buy ",
                    "Question",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options
                );

                // Check if a quantity is selected
                if (inputValue != null){
                    // Get the selected quantity as an int
                    int itemQuantity = (int)inputValue;

                    // Perform the purchase
                    yoFishManager.buyItem(itemQuantity, yoFishTableIndex);
                }
            }else{
                // Display a warning message if the item is out of stock
                JOptionPane.showMessageDialog(null,"'"+ itemName + "' out of stock", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            // Display an error message if no item is selected
            JOptionPane.showMessageDialog(null, "Item not Selected", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buyButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Get the index of the selected row from the YoFish table
        yoFishTableIndex = yoFishTable.getSelectedRow();
    
       // Check if a row is selected
        if (yoFishTableIndex >= 0) {
        // Prompt the user to enter the quantity to add
            int addQuantity = getAddQuantityFromUser();
        
            // Check if a valid quantity is entered
            if (addQuantity > 0) {
                // Retrieve the name of the selected item
                String itemName = yoFishManager.getYoFishList().get(yoFishTableIndex).getItemName();
            
                // Add the specified quantity to the stock using the manager
                int newStock = yoFishManager.addStock(addQuantity, yoFishTableIndex);
            
                // Show a confirmation dialog with details of the addition
                showConfirmationDialog(itemName, addQuantity, newStock);
            
                // Update the stock quantity displayed in the table
                updateTableStock(newStock);
            }
        } else {
        // Show an error message if no item is selected
        showErrorDialog("Item not Selected");
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoFishGUI().setVisible(true);
            }
        });
    }
    
// Initializes the table model, sets up column headers, and links it to the JTable.
// Initializes the table model, sets up column headers, and links it to the JTable.
private void initTable() {
    model = yoFishManager.setupTableModel();
    yoFishTable.setModel(model);
    setupTableHeaders();
}


/**
 * Configures each column header based on predefined column names.
 * Loops through each column and sets the header value.
 */
private void setupTableHeaders() {
    for (int colIndex = 0; colIndex < yoFishTable.getColumnCount(); colIndex++) {
        TableColumn column = yoFishTable.getTableHeader().getColumnModel().getColumn(colIndex);
        column.setHeaderValue(columnNames[colIndex]);
    }
}
/**
 * Displays details of the selected YoFish item.
 * This includes the item name and, if stock is low, displays a warning.
 *
 * @param yoFishTableIndex The index of the selected YoFish item in the table
 */
private void viewSelectedItem(int yoFishTableIndex) {
    
    String itemName = yoFishManager.getCurrentItemName(yoFishTableIndex);
    int stockSize = yoFishManager.getCurrentStockSize(yoFishTableIndex);
    
    itemLabel.setText(itemName);
    displayImage(yoFishTableIndex);
    checkLowStockWarning(itemName, stockSize);
}
/**
 * Displays the image of the selected YoFish item in the picLabel.
 * If the image is unavailable, shows a placeholder message.
 * 
 *  * @param yoFishTableIndex The index of the selected YoFish item in the table
 */
private void displayImage(int yoFishTableIndex) {
    BufferedImage image = yoFishManager.getCurrentImage(yoFishTableIndex);
    if (image == null) {
        displayNoImageAvailable();
    } else {
        setImageToLabel(image);
    }
}

/**
 * Sets a placeholder message in the picLabel when an image is unavailable.
 */
private void displayNoImageAvailable() {
    picLabel.setText("Image not available.");
    picLabel.setIcon(null);
}

/**
 * Sets the given image in the picLabel.
 * 
 * @param image the BufferedImage to display in the picLabel.
 */
private void setImageToLabel(BufferedImage image) {
    picLabel.setText("");
    picLabel.setIcon(new ImageIcon(image));
}
/**
 * Checks if the stock size is below a threshold and displays a warning if so.
 * 
 * @param itemName the name of the YoFish item.
 * @param stockSize the current stock size of the YoFish item.
 */
private void checkLowStockWarning(String itemName, int stockSize) {
    if (stockSize < 5) {
        JOptionPane.showMessageDialog(
            null,
            "'" + itemName + "' has " + stockSize + " units of stock",
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
    }

    
}

/**
 * Prompts the user to select a quantity of the item to add to stock.
 *
 * @return The selected quantity as an integer; returns 0 if no selection is made.
 */
private int getAddQuantityFromUser() {
    // Create an array to hold the options for quantity selection (from 5 to 20)
    Integer[] options = new Integer[16];
    for (int num = 5; num <= 20; num++) {
        options[num - 5] = num; // Populate the options array with values 5 to 20
    }
    
    // Display an input dialog for the user to select a quantity
    Object inputValue = JOptionPane.showInputDialog(
        null,
        "Please select the quantity of the item you wish to Add",
        "Question",
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0] // Set the default selected option to the first in the array
    );

    // Return the selected quantity, or 0 if no selection was made
    return (inputValue != null) ? (int) inputValue : 0;
}


/**
 * Displays a confirmation dialog showing details of the item added to stock.
 *
 * @param itemName    The name of the item that was added.
 * @param addQuantity The quantity of the item that was added.
 * @param newStock    The updated stock quantity after the addition.
 */
private void showConfirmationDialog(String itemName, int addQuantity, int newStock) {
    // Construct and display a message dialog with item details
    JOptionPane.showMessageDialog(null, 
        "Item: " + itemName + // Name of the item
        "\nUnit added: " + addQuantity + // Quantity added to stock
        "\nNew stock quantity: " + newStock // Updated stock quantity
    );
}


/**
 * Updates the stock quantity displayed in the YoFish table for the selected item.
 *
 * @param newStock The updated stock quantity to display in the table.
 */
private void updateTableStock(int newStock) {
    // Update the value in the table model at the specified row and column for stock
    yoFishTable.getModel().setValueAt(newStock, yoFishTableIndex, 3); // Column index 3 corresponds to the stock quantity
}


/**
 * Displays an error dialog with a specified message.
 *
 * @param message The message to be displayed in the error dialog.
 */
private void showErrorDialog(String message) {
    // Show a warning dialog with the provided message
    JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
}

/**
 * Handles the quit request by prompting the user and saving data if confirmed.
 * If the user confirms, saves data before exiting the application.
 */
public void quit() {
    if (confirmQuitRequest()) {
        handleDataSaveAndExit();
    }
}

/**
 * Prompts the user to confirm quitting the application.
 * 
 * @return true if the user confirms; false otherwise.
 */
private boolean confirmQuitRequest() {
    int response = JOptionPane.showConfirmDialog(
        null,
        "Click 'OK' button to confirm Quit request",
        "Please confirm Quit request",
        JOptionPane.OK_CANCEL_OPTION
    );
    return response == JOptionPane.OK_OPTION;
}
/**
 * Saves data, handles any errors that occur, displays a goodbye message, and exits the application.
 */
public void handleDataSaveAndExit() {
    try {
        yoFishManager.saveData();
    } catch (IOException e) {
        handleDataSaveError(e);
    } finally {
        displayGoodbyeMessageAndExit();
    }
}


/**
 * Displays a goodbye message and exits the application.
 */
private void displayGoodbyeMessageAndExit() {
    JOptionPane.showMessageDialog(null, "### Thank you. See you next time ###", "Good Bye", JOptionPane.PLAIN_MESSAGE);
    System.exit(0);
}


/**
 * Handles errors that occur while saving data and shows an error message to the user.
 * 
 * @param e the IOException encountered during the save attempt.
 */
private void handleDataSaveError(IOException e) {
    String message = e instanceof FileNotFoundException
        ? "!!! Output Error: Unable to open output file\n" + e.getMessage()
        : "!!! Output Error: File write error\n" + e.getMessage();
    
    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton buyButton;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JButton quitButton;
    private javax.swing.JTable yoFishTable;
    // End of variables declaration//GEN-END:variables

    // Define table model for YoFish items
    private YoFishTableModel model = yoFishManager.setupTableModel();

    // Define column names for the YoFish table
    private final String [] columnNames = {"ID", "ITEM", "PRICE", "STOCK", "MAX SIZE", "LOW TEMP", "HIGH TEMP"};
        
    // Index to keep track of current YoFish table row
    private int yoFishTableIndex = 0;

        
    

}
