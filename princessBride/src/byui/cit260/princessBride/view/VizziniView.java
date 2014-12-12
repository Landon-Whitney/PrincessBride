/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.control.SceneControl;
import byui.cit260.princessBride.exceptions.SceneControlException;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Scene;
import java.util.logging.Level;
import java.util.logging.Logger;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class VizziniView extends View {
    
    public VizziniView () {
        super("\n\n***********************************************************************"
        + "\n*                    Vizzini's Poison Puzzle                          *"
        + "\n*                                                                     *"
        + "\n*So it's down to you and me...I can't complete with you physically    *"
        + "\n*and you're no match for my brains. Let me put it this way. Have you  *"
        + "\n*ever heard of Plato, Aristotle, Socrates? Morons.                    *"
        + "\n*                                                                     *"
        + "\n*You offer to duel Vizzini in a battle of the wits. You will pour two *"
        + "\n*glasses of wine, one of which is poisened, and tell Vizzini he may   *"
        + "\n*choose which glass to drink from. You will drink from the remaining  *"
        + "\n*glass. BUT, what Vizzini doesn't know is that you have built a       *"
        + "\n*resistance to iocane powder up to the strength of a 2% solution.     *"
        + "\n*                                                                     *"
        + "\n*You must only make sure you mix the solution to no stronger than 2%  *"
        + "\n*or you will die too!                                                 *"
        + "\n*Will you accept this challenge from Vizzini?                         *"
        + "\n*(Enter Y or N)                                                       *"
        + "\n***********************************************************************"
        );
    }
    
    @Override
    public void doAction(char selection) {
        switch (Character.toUpperCase(selection)){
            case 'Y':
                try {
                    this.wineChallenge();
                } catch (SceneControlException ex){
                    ErrorView.display(this.getClass().getName(), "Error reading input: "+ ex.getMessage());
                }
                break;
            case 'N':
                super.console.println("As you wish.");
                break;
            default:
                super.console.println("\nInconceivable! Please select 'Y' for yes or 'N' for no.");
                break;
        }   
    }

    public void wineChallenge() throws SceneControlException {
        int gramsIocane;
        int gramsWine;
        Double percentSolution = null;
        
        do{
            super.console.println("Please enter the grams of wine in the glass:");
            gramsWine = super.getNumInput();
        
            super.console.println("Please enter the grams of iocane in the glass:");
            gramsIocane = super.getNumInput();
        
            SceneControl solution = new SceneControl();
            percentSolution = solution.percentSolution(gramsIocane, gramsWine);
        }while(percentSolution == null); 
        
        if (percentSolution < 2 || percentSolution == 2){
            super.console.println("\nYou've successfully defeated Vizzini (he's dead) and survived the iocane powder!");
            Scene.VizzinisPoisonPuzzle.setCompleted(Boolean.TRUE);
            
            super.console.println("\nFrom Vizzini you've won a goblet of water and a knife.");
            super.console.println("These items have been added to your inventory.");
            InventoryControl inventory = new InventoryControl();
            inventory.addItem("Goblet");
            inventory.addItem("Knife");
        }
        else {
            super.console.println("The solution strength was above 2%!");
            DefeatMenuView defeatMenu = new DefeatMenuView();
            defeatMenu.displayMenu();
        }
    }

}
