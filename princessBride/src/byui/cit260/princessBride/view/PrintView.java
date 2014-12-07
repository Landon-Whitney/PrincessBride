/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.InventoryItem;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author whitneydavis
 */
public class PrintView {

    public void printInventory(String filePath) throws IOException {
        
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream inventoryReport = new ObjectOutputStream(fops);
            //print out title
            inventoryReport.writeObject("Inventory List");
            //print out column headings
            inventoryReport.writeObject("\n\nName\tDescription\tQuantity"); //http://stackoverflow.com/questions/6000810/printing-with-t-tabs-does-not-result-in-aligned-columns
            //get inventorylist from game
            Game game = new Game();
            InventoryItem [] inventoryList = game.getInventoryList();
            //iterate through and print out each item
            for (InventoryItem inventoryItem: inventoryList){
                String description = inventoryItem.getDescription();
                double quantity = inventoryItem.getQuantity();
            
                inventoryReport.writeObject("\n" + inventoryItem + "\t" + description + "\t" + quantity);
            }
        }catch (IOException e) {
            ErrorView.display(this.getClass().getName(), "Error printing: Unable to print inventory list."); 
        }
    }

   
    
}
