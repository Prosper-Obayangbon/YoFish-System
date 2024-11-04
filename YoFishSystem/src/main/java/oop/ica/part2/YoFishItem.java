/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

/**
 *
 * @author Prosper Nosa Obyangbon 
 * D3424757
 */

/**
 * YoFishItem class represents a type of fish item with various attributes such as ID, name, price, stock, 
 * maximum size, low temperature, and high temperature.
 */
public class YoFishItem {
    // Fields
    private int id;
    private String itemName;
    private double price;
    private int stock;
    private double maxSize;
    private int lowTemp;
    private int highTemp;
    
    /**
     * Constructs a YoFishItem object with the specified attributes.
     * @param id The ID of the fish item.
     * @param itemName The name of the fish item.
     * @param price The price of the fish item.
     * @param stock The current stock quantity of the fish item.
     * @param maxSize The maximum size of the fish.
     * @param lowTemp The low temperature at which the fish can survive.
     * @param highTemp The high temperature at which the fish can survive.
     */
    public YoFishItem(int id, String itemName, double price, int stock, double maxSize, int lowTemp, int highTemp) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
        this.maxSize = maxSize;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
    }

    /**
     * Sets the stock quantity of the fish item.
     * @param stock The new stock quantity to set.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    /**
     * Retrieves the ID of the fish item.
     * @return The ID of the fish item.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retrieves the name of the fish item.
     * @return The name of the fish item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Retrieves the price of the fish item.
     * @return The price of the fish item.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Retrieves the current stock quantity of the fish item.
     * @return The current stock quantity of the fish item.
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Retrieves the maximum size of the fish.
     * @return The maximum size of the fish.
     */
    public double getMaxSize() {
        return this.maxSize;
    }

    /**
     * Retrieves the low temperature at which the fish can survive.
     * @return The low temperature at which the fish can survive.
     */
    public int getLowTemp() {
        return this.lowTemp;
    }

    /**
     * Retrieves the high temperature at which the fish can survive.
     * @return The high temperature at which the fish can survive.
     */
    public int getHighTemp() {
        return this.highTemp;
    }
    
    /**
     * Formats the price of the fish item with a currency symbol.
     * @return The formatted price of the fish item.
     */
    public String getFormattedPrice(){
        return String.format("£ %.2f", this.price);
    }
    
    /**
     * Retrieves the filename of the image associated with the fish item.
     * @return The filename of the image associated with the fish item.
     */
    public String getImageFilename(){
        return this.id + ".jpg";
    }
}
 
