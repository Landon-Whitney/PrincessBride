/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Scene;

/**
 *
 * @author Robbie
 */
public class MapControl {
    

    
    
    public static Map createMap(){
         
        //create the map for the game
        Map map = new Map (3,3);
        //create the scenes for the game
        
        //assign scenes to locations
        MapControl.movePlayerToStartingLocation(map);
        
        return map;
    }
    

    
      

    public static void movePlayerToStartingLocation(Map map){
        // move player to starting scene
        Location location = map.getLocations()[0][0];
        location.setPlayer(princessbride.PrincessBride.getPlayer());
        princessbride.PrincessBride.getPlayer().setLocation(location);

    }

    private void assignScenesToLocations(Map map) {
        Location location = map.getLocations()[0][1];
        location.setScene(Scene.CastleGate);
        
        location = map.getLocations()[0][1];
        location.setScene(Scene.CastleMaze);
        
        // ...
    }

    
}
