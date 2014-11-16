/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Inventory;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.model.Scene;
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
        
        Inventory[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap();
        game.setMap(map);
        
        MapControl.moveActorsToStartingLocation(map);
    }
    
    public static Inventory[] createInventoryList(){
           System.out.println("** called createInventoryList in GameControl**");
           return null;
       
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
       
    }


}
