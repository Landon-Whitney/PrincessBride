/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.control.SceneControl;
import byui.cit260.princessBride.exceptions.SceneControlException;
import byui.cit260.princessBride.model.Scene;

/**
 *
 * @author whitneydavis
 */
public class MiracleMaxView extends View {

    private final String INSTRUCTIONS = "\n\nTo add the ingredients to the recipe you must first tell"
                           + "\nMiracle Max the radius and height of the measuring cup you"
                           + "\nneed in centimeters. There can be many correct combinations"
                           + "\nas long as the radius and height calculate to the correct"
                           + "\nvolume in Liters."
                           + "\n"
                           + "\nHINT: Miracle Max thinks the radius and heights of the volumes"
                           + "\nhave to do with his favorite numbers: 5 and 6.";
    
    private final String RECIPE = "\n"
            + "\n----------------------------------------"
            + "\n           Miracle Pill Recipe          "
            + "\n----------------------------------------"
            + "\n1 - .57 Liters of ROUS spit             "
            + "\n2 - .47 Liters of Shrieking Eel blood "
            + "\n3 - 5.18 Liter of Buttercup's tears"
            + "\n4 - 6.2 Liters of Milk"
            + "\n"
            + "\nCombine all ingredients until well mixed,"
            + "\nform into a pill, and then let sit for   "
            + "\n24 hours before consuming."
            + "\n----------------------------------------"
            + "\n"
            + "\nSelect an option above(1-4):";
    
    public MiracleMaxView() {
        super("\n\n*************************************************"
                + "\n*                 Miracle Max                   *" 
                + "\n*                                               *"
                + "\n* Fezzik and Inigo have had a change of heart   *"
                + "\n* and want to help you rescue Buttercup. They   *"
                + "\n* have dragged you from the Pit of Despair to a *"
                + "\n* famous healer, called Miracle Max. They       *"
                + "\n* convince Miracle Max that you have a noble    *"
                + "\n* cause, he agrees to give you a miracle pill   *"
                + "\n* that will bring you back from being mostly    *"
                + "\n* dead. The only problem is, Miracle Max doesn't*"
                + "\n* remember how to mix the pill. He does have a  *"
                + "\n* recipe, however, with writing that is too     *"
                + "\n* small. He also can't remember which measuring *"
                + "\n* cups will provide the right volume. To make   *"
                + "\n* the Miracle Pill, you must give the correct   *"
                + "\n* radius and height of the measuring cup so     *"
                + "\n* Miracle Max can mix it.                       *"
                + "\n*************************************************"
                + "\n\nWould you like to mix the miracle pill for Max?"
                + "\nEnter Y or N");
    }
    
    @Override
    public void doAction(char value) {
        // if value is N then return to main menu view
        if (value == 'N') {
            this.console.println("As you wish.");
        }
        else {    
            try {
                this.miracleMaxChallenge();
            } catch (SceneControlException ex) {
                ErrorView.display(this.getClass().getName(), "Error reading input: "+ ex.getMessage());
            }
        }
    }

    public void miracleMaxChallenge () throws SceneControlException {
        int ingredients = 0;
        double[] neededVolumeArray = {.57, .47, 5.18, 6.22};
        double addedVolume;
        double neededVolume;
        int remainingIngredients = 4;
        
        this.console.println(INSTRUCTIONS);
        
        while (ingredients < 4) {
            this.console.println(RECIPE);
            //get which ingredient
            int input = this.getNumInput();
            //get the amount needed for the recipe
            if (input > 0 && input < 5){
                neededVolume = neededVolumeArray[input-1];
            }
            else {
                ErrorView.display(this.getClass().getName(), "\nInconceiveable! Please select an option between 1 and 4:");
                continue;
            }
            //get the inputs for radius and height from the player
            this.console.println("Enter the radius needed:");
            int radius = this.getNumInput();
            this.console.println("Enter the height needed:");
            int height = this.getNumInput();
            
            //calculate the volume added by the player from the inputs
            SceneControl miracleMaxControl = new SceneControl();
            addedVolume = miracleMaxControl.calculateIngredientVolume(radius, height);
            
            //compare the amount added to the amount needed
            if (addedVolume == neededVolume){
                ingredients = ++ingredients;
                remainingIngredients = 4 - ingredients;
                this.console.println("You've sucessfully added one ingredient from the recipe! Only " + remainingIngredients + " left!");
            }
            else {
               this.console.println("You rush a miracle man, you get rotten miracles. You added the wrong amount of ingredient, try again!");
               DefeatMenuView defeatMenu = new DefeatMenuView();
               defeatMenu.displayMenu();
               break;
            }
            
            if (remainingIngredients == 0){
                this.console.println("You've sucessfully mixed the Miracle Pill! This pill will restore your mostly dead self to mostly alive!");
        
                //set scene to completed
                Scene.MiracleMax.setCompleted(Boolean.TRUE);
        
                //add items to inventory
                InventoryControl inventory = new InventoryControl();
                inventory.addItem("Miracle Pill");
                inventory.addItem("Holocaust Cloak");
            }
        }
    }  
    
    //1. r = 6 h = 5
    //2. r = 5 h = 6
    //2. r = 5 h = 66
    //4. r = 6 h = 55

}
