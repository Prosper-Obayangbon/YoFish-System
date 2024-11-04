# YoFish Inventory Management System

This project, developed as part of a course module in Object Oriented Programming(OOP) Teesside University, is an inventory management application for tracking and managing items in a YoFish inventory. 
The application provides functionality to add, purchase, and manage the stock of items, including images and basic analytics.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Project Overview

The YoFish Inventory Management System enables users to:
- Display item details, including name, stock quantity, price, and other specifications.
- Load images associated with each item.
- Track stock levels and update them when items are purchased or restocked.
- Warn the user when stock is low for specific items.

This project is part of a course module to demonstrate understanding of GUI development in Java, file I/O, and object-oriented design.

## Features

- **Add Items**: Allows users to add specific quantities of items to the inventory.
- **Purchase Items**: Lets users select quantities for purchase, updating the stock accordingly.
- **Low Stock Warnings**: Automatically warns users when an item’s stock falls below a predefined threshold.
- **Data Persistence**: Saves data to `Output.txt` for future reference.
- **Image Loading**: Loads and displays images for each inventory item.

## Technologies Used

- **Java**: Core programming language for the application.
- **Swing**: Java's GUI toolkit for building the user interface.
- **Java I/O**: For reading and writing data files.
- **GitHub**: Used for version control.
- **Figma**: For initial design (if applicable).

## Installation

1. **Clone the repository**:
   
   git clone https://github.com/your-username/YoFish-Inventory.git
   
2. Navigate to the project directory:
 
cd YoFish-System

Open the project in your preferred Java IDE (e.g., IntelliJ IDEA or Eclipse).
Run the project:
Compile and execute YoFishGUI.java to start the application.
Usage

3.**Load Data**: 
-The application initializes by loading data from yo-fish.txt.
-Adding Stock: Select an item and specify the quantity to add.
-Buying Items: Choose an item and specify the quantity to buy. The application will update the stock and alert if stock is low.
-View Item Details: Display the selected item’s image and relevant details.
-Save Data: Data can be saved to Output.txt for later use.
-Project Structure

4. **src/oop/ica/part2**:
Main source code package containing:
-YoFishGUI: Main GUI class for user interaction.
-YoFishManager: Handles core functionality like data management and stock updates.
-DataManager: Utility class for file handling.
-ImageLoader: Loads images associated with each item.


5. **License**

This project is created for educational purposes as part of a university course. It is not intended for commercial use.

javascript
Copy code

Be sure to replace `OOP, Teesside University`  in the link with the relevant details. You can add further customization or additional sections as needed!






