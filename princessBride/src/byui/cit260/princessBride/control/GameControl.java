/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.MapControlException;
import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Scene;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;


/**
 *
 * @author whitneydavis
 */
public class GameControl {
    
    public static void createNewGame(Player player) throws MapControlException {
        Game game = new Game ();//new game
        PrincessBride.setCurrentGame(game);//save game
        
        game.setPlayer(player);//save player in game   
        
        //create the inventory list and save in game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap();//create new wagon
        game.setMap(map);//save map in game
        
        //move player to starting position in game
        //MapControl.moveActorsToStartingLocation(map); Actors dont move in our game
        
       
    }
    
    public static InventoryItem[] createInventoryList(){
           System.out.println("** called createInventoryList in GameControl**");
           return null;
       
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
