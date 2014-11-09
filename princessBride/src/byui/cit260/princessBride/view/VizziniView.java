/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.control.SceneControl;

/**
 *
 * @author whitneydavis
 */
public class VizziniView extends View {
    
    public VizziniView () {
        super("So it's down to you and me...I can't complete with you physically"
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
        );
    }
    
    public void faceVizzini() {
        String answer;
        
        System.out.println("Would you like to continue and face Vizzini in a battle of the wits?");
        answer = super.getInput();
        
        if ("yes".equals(answer)|| "Yes".equals(answer)){
            this.wineChallenge();
        }
        else if ("no".equals(answer)||"No".equals(answer)){
            System.out.println("As you wish");
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.displayMenu();
        }
        else {
            System.out.println("Please answer yes or no.");
        }   
    }

    public void wineChallenge() {
        int gramsIocane;
        int gramsWine;
        double percentSolution;
        
        System.out.println("Please enter the grams of wine in the glass:");
        gramsWine = super.getNumInput();
        
        System.out.println("Please enter the grams of iocane in the glass:");
        gramsIocane = super.getNumInput();
        
        SceneControl solution = new SceneControl();
        percentSolution = solution.percentSolution(gramsIocane, gramsWine);
        
        if (percentSolution < 2 || percentSolution == 2){
            System.out.println("You've successfully defeated Vizzini (he's dead) and survived the iocane powder!");
            System.out.println("From Vizzini you've won a bottle of wine and a knife.");
            InventoryControl inventory = new InventoryControl();
            inventory.addItem("Bottle of wine");
            inventory.addItem("Knife");
            
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.displayMenu();
        }
        else {
            DefeatMenuView defeatMenu = new DefeatMenuView();
            defeatMenu.displayMenu();
        }
    }
    
    @Override
    public void doAction(char selection) {
        
    }
}
