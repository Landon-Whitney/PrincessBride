/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.view.FireswampView;
import byui.cit260.princessBride.view.StartProgramView;

/**
 *
 * @author whitneydavis
 */
public class PrincessBride {
    
    private static Game currentGame = null;
    private static Player player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PrincessBride.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        PrincessBride.player = player;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create StartProgramView and start the program
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
    }
    
}
