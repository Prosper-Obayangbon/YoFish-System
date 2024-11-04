/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

/**
 *
 * @author obaya
 */

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class YoFishTableModel extends AbstractTableModel{
    private String[] columnNames;
    private Object[][] tableData;

    public YoFishTableModel( final String[] columnNames, final List<YoFishItem> dataList) {
        int columnNamesLength = columnNames.length;
        int rowLength = dataList.size();
        
        this.columnNames = Arrays.copyOf(columnNames, columnNamesLength);
        this.tableData = new Object[rowLength][columnNamesLength];
        
        for(int index = 0; index < rowLength; index++){
            int id = dataList.get(index).getId();
            String itemName = dataList.get(index).getItemName();
            String price = dataList.get(index).getFormattedPrice();
            int stock = dataList.get(index).getStock();
            double maxSize = dataList.get(index).getMaxSize();
            int lowTemp = dataList.get(index).getLowTemp();
            int highTemp = dataList.get(index).getHighTemp();
            
            Object[] dataRow = new Object[] {id, itemName, price, stock, maxSize, lowTemp, highTemp};
            
            tableData[index] = Arrays.copyOf(dataRow, columnNamesLength);
        }
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public int getRowCount(){
        return tableData.length;
    }
    @Override
    public Object getValueAt(int row, int column){
        return tableData[row][column];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        tableData[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    
    
}
