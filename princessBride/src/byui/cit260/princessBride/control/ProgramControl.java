/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;


/**
 *
 * @author Robbie
 */
public class ProgramControl {

    public static Player createPlayer(String name) {
        
        Player player = new Player();
        player.setName(name);
        
        PrincessBride.setPlayer(player);
        
        return player;
    }

}
    
    

