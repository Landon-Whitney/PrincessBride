/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.InventoryItem;
import java.io.FileWriter;
import java.io.IOException;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class PrintView {

    public void printInventory(String filePath) throws IOException {
        
        try (FileWriter inventoryReport = new FileWriter(filePath)) {
            //print out title
            String title = "Inventory List";
            inventoryReport.write(title);
            //print out column headings
            String catagories = "\n\n\nName\t\tDescription\t\tQuantity\n";
            inventoryReport.write(catagories); //http://stackoverflow.com/questions/6000810/printing-with-t-tabs-does-not-result-in-aligned-columns
            //get inventorylist from game
            Game game = PrincessBride.getCurrentGame();
            InventoryItem [] inventoryList = game.getInventoryList();
            //iterate through and print out each item
            for (InventoryItem inventoryItem: inventoryList){
                String description = inventoryItem.getDescription();
                double quantity = inventoryItem.getQuantity();
            
                inventoryReport.write("\n" + inventoryItem + "\t\t" + description + "\t\t   " + quantity);
            }
        }catch (IOException e) {
            ErrorView.display(this.getClass().getName(), "Error printing: Unable to print inventory list."); 
        }
    }

   
    
}
