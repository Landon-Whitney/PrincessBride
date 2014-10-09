/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.Actor;
import byui.cit260.princessBride.model.Inventory;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.model.Map;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Scene;
import byui.cit260.princessBride.model.Messages;

/**
 *
 * @author whitneydavis
 */
public class PrincessBride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testing Player class
        Player playerOne = new Player();
        
        playerOne.setName("Bob");
        playerOne.setBestTime(2.00);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);

        //testing Map class
        Map mapOne = new Map();
        
        mapOne.setRowCount(3);
        mapOne.setColumnCount(7);
        
        String mapInfo = mapOne.toString();
        System.out.println(mapInfo);
        
        //testing Location Class
        Location placeOne = new Location();
        
        placeOne.setRow(3);
        placeOne.setColumn(7);
        placeOne.setBlocked(Boolean.TRUE);
        placeOne.setDescription("castle");
        
        String placeInfo = placeOne.toString();
        System.out.println(placeInfo);
        
        //testing Scene class
        Scene sceneOne = new Scene();
        
        sceneOne.setDescription("Mostly Dead");
        sceneOne.setBlocked(Boolean.FALSE);
        sceneOne.setStatus(Boolean.TRUE);
        
        String sceneInfo = sceneOne.toString();
        System.out.println(sceneInfo);
        
        //testing Messages class
        Messages messageOne = new Messages();
        
        messageOne.setResponse("Come here and fight like a man!");
        
        String messageInfo = messageOne.toString();
        System.out.println(messageInfo);
        
        Actor actorOne = new Actor ();
        
        actorOne.setName("Witch Hazel");
        actorOne.setDefeated(Boolean.TRUE);
        
        String actorInfo = actorOne.toString();
        System.out.println(actorInfo);
        
        Inventory inventoryOne = new Inventory ();
        
        inventoryOne.setQuantity(3);
        
        String inventoryInfo = inventoryOne.toString();
        System.out.println(inventoryInfo);
       
    }
    
}
