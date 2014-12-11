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
        super("\n\nSo it's down to you and me...I can't complete with you physically"
        + "\nand you're no match for my brains. Let me put it this way. Have you"
        + "\never heard of Plato, Aristotle, Socrates? Morons."
        + "\n"
        + "\nYou offer to duel Vizzini in a battle of the wits. You will pour two"
        + "\nglasses of wine, one of which is poisened, and tell Vizzini he may "
        + "\nchoose which glass to drink from. You will drink from the remaining"
        + "\nglass. BUT, what Vizzini doesn't know is that you have built a resistance"
        + "\nto iocane powder up to the strength of a 2% solution."
        + "\n"
        + "\nYou must only make sure you mix the solution to no stronger than 2%"
        + "\nor you will die too!"
        + "\nWill you accept this challenge from Vizzini?"
        + "\n(Enter Y or N)"
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
            case 'N':
                super.console.println("As you wish");
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
                break;
            default:
                super.console.println("Please answer yes or no.");
                break;
        }   
    }

    public void wineChallenge() throws SceneControlException {
        int gramsIocane;
        int gramsWine;
        double percentSolution;
        
        super.console.println("Please enter the grams of wine in the glass:");
        gramsWine = super.getNumInput();
        
        super.console.println("Please enter the grams of iocane in the glass:");
        gramsIocane = super.getNumInput();
        
        SceneControl solution = new SceneControl();
        percentSolution = solution.percentSolution(gramsIocane, gramsWine);
        
        if (percentSolution < 2 || percentSolution == 2){
            super.console.println("You've successfully defeated Vizzini (he's dead) and survived the iocane powder!");
            Scene.VizzinisPoisonPuzzle.setCompleted(Boolean.TRUE);
            
            super.console.println("From Vizzini you've won a bottle of wine and a knife.");
            InventoryControl inventory = new InventoryControl();
            inventory.addItem("Goblet of water");
            inventory.addItem("Knife");
            
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
        }
        else {
            DefeatMenuView defeatMenu = new DefeatMenuView();
            defeatMenu.display();
        }
    }

}
