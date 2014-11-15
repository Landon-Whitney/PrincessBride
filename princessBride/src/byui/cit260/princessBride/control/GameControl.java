/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;


/**
 *
 * @author whitneydavis
 */
public class GameControl {
    
    public static void createNewGame(Player player) {
        System.out.println("createNewGame stub function called");
    }
    
    public static Item[] getSortedInventoryList() {
        //get inventory list for the current game
        Item[] originalInventoryList =
                PrincessBride.getCurrentGame().getInventory();
        
        //clone (make a copy) of the oringinal list
        Item[] inventoryList = originalInventoryList.clone();
        
        //using a selection sort to sort the list of inventoryList by name
        Item tempInventoryItem;
        for (int i = 0; i < inventoryList.length-1; i++) {
            int min = i;
            for (int j = i+1; j < inventoryList.length; j++) {
                if (inventoryList[min].getDescription().compareToIgnoreCase(inventoryList[j].getDescription())>0) 
                    min = j;
                Item temp = inventoryList[i];
                inventoryList[i] = inventoryList[min];
                inventoryList[min] = temp;
            }
        }
        
        return inventoryList;
    }
}
