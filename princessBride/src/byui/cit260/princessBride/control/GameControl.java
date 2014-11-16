/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.model.Scene;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;


/**
 *
 * @author whitneydavis
 */
public class GameControl {
    
    public static void createNewGame(Player player) {
        Game game = new Game ();
        PrincessBride.setCurrentGame(game);
        
        game.setPlayer(player);    
        
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap();
        game.setMap(map);
        
        MapControl.moveActorsToStartingLocation(map);
    }
    
    public static InventoryItem[] createInventoryList(){
           System.out.println("** called createInventoryList in GameControl**");
           return null;
       
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
       
    }
    
     public static InventoryItem[] getSortedInventoryList() {
        //get inventory list for the current game
        InventoryItem[] originalInventoryList = PrincessBride.getCurrentGame().getinventoryList();
        
        //clone (make a copy) of the oringinal list
        InventoryItem[] inventoryList = originalInventoryList.clone();
        
        //using a selection sort to sort the list of inventoryList by name
        Item tempInventoryItem;
        for (int i = 0; i < inventoryList.length-1; i++) {
            int min = i;
            for (int j = i+1; j < inventoryList.length; j++) {
                if (inventoryList[min].getDescription().compareToIgnoreCase(inventoryList[j].getDescription())>0) 
                    min = j;
                InventoryItem temp = inventoryList[i];
                inventoryList[i] = inventoryList[min];
                inventoryList[min] = temp;
            }
        }
        
        return inventoryList;
    }
}
