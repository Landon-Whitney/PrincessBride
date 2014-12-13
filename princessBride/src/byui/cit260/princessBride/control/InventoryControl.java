/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;
import byui.cit260.princessBride.exceptions.InventoryControlException;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Item;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class InventoryControl {

    public void addItem(String item) {
        InventoryItem [] inventory = PrincessBride.getCurrentGame().getInventoryList();
        for (InventoryItem inventoryItem : inventory) {
            if (inventoryItem.toString().equals(item)) {
                inventoryItem.setQuantity(1);
                return;
            }
        }
    }
    
    public static InventoryItem[] getSortedInventoryList() {
        //get inventory list for the current game
        InventoryItem[] originalInventoryList = PrincessBride.getCurrentGame().getInventoryList();
        
        //clone (make a copy) of the oringinal list
        InventoryItem[] inventoryList = originalInventoryList.clone();
        
        //using a selection sort to sort the list of inventoryList by name
        for (int i = 0; i < inventoryList.length-1; i++) {
            int min = i;
            for (int j = i+1; j < inventoryList.length; j++) {
                if (inventoryList[min].getName().compareToIgnoreCase(inventoryList[j].getName())>0) 
                    min = j;
                InventoryItem temp = inventoryList[i];
                inventoryList[i] = inventoryList[min];
                inventoryList[min] = temp;
            }
        }
        
        return inventoryList;
    }
    
}
