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
public class MiracleMaxView extends View {

    
    private final String RECIPE = "\n"
            + "\n----------------------------------------"
            + "\n           Miracle Pill Recipe          "
            + "\n----------------------------------------"
            + "\n1.  .57 Liters of ROUS spit                "
            + "\n2.  .47 Liters of Shrieking Eel blood "
            + "\n3.  5.18 Liter of Buttercup's tears"
            + "\n4.  6.2 Liters of Milk"
            + "\n"
            + "\nCombine all ingredients until well mixed,"
            + "\nform into a pill, and then let sit for   "
            + "\n24 hours before consuming."
            + "\nE - Exit "
            + "\n----------------------------------------";
    
 

    public MiracleMaxView() {
        super("\n\n*************************************************"
                + "\n\n*                 Miracle Max                    *" 
                + "*                                               *"
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
                + "\n\n*************************************************"
                + "\n\nWould you like to mix the miracle pill for Max?"
                + "\nEnter Y or N");
    }


    
    public void displayIngredientList () {
        int ingredients = 0;
        char selection = ' ';
        double neededVolume;
        double addedVolume;
        int radius = 0;
        int height = 0;
        int remainingIngredients = 4;
        
        SceneControl miracleMaxControl = new SceneControl();
        System.out.println("To add the ingredients to the recipe you must first tell Miracle Max the radius and height of the measuring cup you need in centimeters.");
        System.out.println("There can be many correct combinations as long as the radius and height calculate to the correct volume in Liters.");
        System.out.println("HINT: Miracle Max thinks the radius and heights of the volumes have to do with his favorite numbers: 5 and 6. Volume = radius^2 * pi * height");
        
        while (ingredients < 4) {
            System.out.println(RECIPE);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            //get the amount needed for the recipe
            neededVolume = this.findNeededVolume(selection);
            
            //get the inputs for radius and height from the player

            System.out.println("Enter the radius needed:");
            radius = this.getNumInput();
            System.out.println("Enter the height needed:");
            height = this.getNumInput();
            
            //calculate the volume added by the player from the inputs
            addedVolume = miracleMaxControl.calculateIngredientVolume(radius, height);
            
            //compare the amount added to the amount needed
            if (addedVolume == neededVolume){
                ingredients = ++ingredients;
                remainingIngredients = 4 - ingredients;
                System.out.println("You've sucessfully added one ingredient from the recipe! Only" + remainingIngredients + "to go!");
            }
            else {
               System.out.println("You rush a miracle man, you get rotten miracles. You added the wrong amount of ingredient, try again!");
               this.displayDefeatMenu();
               break;
            }
        }
        System.out.println("You've sucessfully mixed the Miracle Pill! This pill will restore your mostly dead self to mostly alive!");
        InventoryControl inventory = new InventoryControl();
        inventory.addItem("Miracle Pill");
        inventory.addItem("Holocaust Cloak");
        
        //display Game Menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
    
    
    
    private double findNeededVolume(char selection) {
        double neededVolume = 0.0;
        switch (selection) {
            case '1':
                neededVolume = 0.57; // r = 6 h = 5
                break;
            case '2':
                neededVolume = 0.47; // r = 5 h = 6
                break;
            case '3':
                neededVolume = 5.18; // r = 5 h = 66
                break;
            case '4':
                neededVolume = 6.22; // r = 6 h = 55
                break;
            case 'E':
                break;
            default:
                System.out.println("\nInconceivable! Please select an option from the recipe.");
                break;
        }
        return neededVolume;
    }



    private void displayDefeatMenu() {
        DefeatMenuView defeatMenu = new DefeatMenuView();
        defeatMenu.displayMenu();
    }

    @Override
    public void doAction(char value) {
        // if value is N then return to main menu view
        if (value == 'N') {
            // display game menu view
        }
            
        
        displayIngredientList ();
    }
}
