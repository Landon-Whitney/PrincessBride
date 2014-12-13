/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.exceptions.GameControlException;
import byui.cit260.princessBride.model.Actor;
import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import princessbride.PrincessBride;


/**
 *
 * @author whitneydavis
 */
public class GameControl {
    
    
    public static void createNewGame(Player player) {
        Game game = new Game ();//new game
        PrincessBride.setCurrentGame(game);//save game
        
        game.setPlayer(player);//save player in game   
        
        //create the inventory list and save in game
        InventoryItem[] inventoryList = InventoryItem.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap();//create new wagon
        game.setMap(map);//save map in game
        
        //move player to starting position in game
        //MapControl.moveActorsToStartingLocation(map); Actors dont move in our game

    }

    public static void saveGame(Game game, String filePath) 
            throws GameControlException{
        
        try( FileOutputStream fops = new FileOutputStream(filePath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        }
        catch(IOException e){
            e.printStackTrace();
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filePath) 
            throws GameControlException{
       Game game = null;
       
       try( FileInputStream fips = new FileInputStream(filePath)){
           ObjectInputStream output = new ObjectInputStream(fips);
           
           game = (Game) output.readObject();
       }catch ( FileNotFoundException fnfe){
           throw new GameControlException (fnfe.getMessage());
       }
       catch(Exception e){
           throw new GameControlException(e.getMessage());
       }
       PrincessBride.setCurrentGame(game);
    }
    
    public static void saveActor (Actor[] actor, String filePath)
            throws GameControlException{
         try{ FileOutputStream fops = new FileOutputStream(filePath);
             try (ObjectOutputStream output = new ObjectOutputStream(fops)) {
                 for(Actor a:actor){
                     output.writeObject(a);
                     output.flush();
                 }}
        }
        catch(IOException e){
            throw new GameControlException(e.getMessage());
        }
    
    }
    }

