/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.MapControlException;
import byui.cit260.princessBride.model.Actor;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.model.Scene;
import java.awt.Point;
import princessbride.PrincessBride;

/**
 *
 * @author Robbie
 */
public class MapControl {
    

    
    
    public static Map createMap(){
         
        //create the map for the game
        Map map = new Map (3,3);
        //create the scenes for the game
        //Scene[] scenes = createScenes(); don't need right now...
        //assign scenes to locations
        MapControl.assignScenesToLocations(map);
        
        return map;
    }
    

    public static void moveActorToLocation(Actor actor, Point coordinates)
            throws MapControlException {
            
        
        Map map = PrincessBride.getCurrentGame().getMap();
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        
        if(newRow < 0 || newRow >= map.getRowCount()|| newColumn < 0 || newColumn >= map.getColumnCount()){
            throw new MapControlException("Can not move player to location" + coordinates.x + ", " + coordinates.y +" because that location is outside the bounds of the map.");
        }
        
    }
    public static void moveActorsToStartingLocation (Map map)
            throws MapControlException {
        Actor [] actors = Actor.values();
        for (Actor actor : actors){
            Point coordinates = actor.getCoordinates();
            MapControl.moveActorToLocation(actor, coordinates);
 
        }
      }

      

    public static void movePlayerToStartingLocation(Map map){
        // move player to starting scene
        Location location = map.getLocations()[0][0];
        location.setPlayer(princessbride.PrincessBride.getPlayer());
        princessbride.PrincessBride.getPlayer().setLocation(location);

    }

    
    private static Scene[] createScenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private static void assignScenesToLocations(Map map) {
        Location location = map.getLocations()[0][0];
        location.setScene(Scene.InigosGrotto);
        location.getScene().setBlocked(false);
        
        location = map.getLocations()[0][1];
        location.setScene(Scene.FezzicksChallenge);
        location.getScene().setBlocked(false);
        
        location = map.getLocations()[0][2];
        location.setScene(Scene.VizzinisPoisonPuzzle);
        location.getScene().setBlocked(false);
        
        location = map.getLocations()[1][0];
        location.setScene(Scene.Fireswamp);
        location.getScene().setBlocked(true);
        
        location = map.getLocations()[1][1];
        location.setScene(Scene.PitOfDespair);
        location.getScene().setBlocked(true);
        
        location = map.getLocations()[1][2];
        location.setScene(Scene.MiracleMax);
        location.getScene().setBlocked(true);
        
        location = map.getLocations()[2][0];
        location.setScene(Scene.CastleGate);
        location.getScene().setBlocked(true);
        
        location = map.getLocations()[2][1];
        location.setScene(Scene.CastleMaze);
        location.getScene().setBlocked(true);
        
        location = map.getLocations()[2][2];
        location.setScene(Scene.TrueLovesKiss);
        location.getScene().setBlocked(true);
        
        // ...
    }

    
}
