/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.SceneControl;
import byui.cit260.princessBride.model.Scene;
import java.util.Scanner;
/**
 *
 * @author whitneydavis
 */
public class MiracleMaxView {
    private final String RECIPE = "\n"
            + "\n----------------------------------------"
            + "\n           Miracle Pill Recipe          "
            + "\n----------------------------------------"
            + "\n1.  2 Liters of ROUS spit                "
            + "\n2.  .5 Liters of Shrieking Eel blood "
            + "\n3.  1 Liter of Buttercup's tears"
            + "\n4.  3 Liters of Milk"
            + "\n"
            + "\nCombine all ingredients until well mixed,"
            + "\nform into a pill, and then let sit for   "
            + "\n24 hours before consuming."
            + "\nE - Exit "
            + "\n----------------------------------------";
    
    public void miracleMaxScene () {
        
        String selection = null;
        Scanner keyboard = new Scanner(System.in);
        
        //Display storyline continuation
        this.displayStoryline();
        //Ask player if they would like to continue
        System.out.println("Would you like to mix the miracle pill for Max?");
            
        selection = keyboard.nextLine();
        selection = selection.trim();
            
        if ("yes".equals(selection) || "Yes".equals(selection)){
            this.displayIngredientList();
        }
        else if ("no".equals(selection)|| "No".equals(selection)) {
            System.out.println("As you wish. Returning to the Game Menu.");
            GameMenuView gameMenuView = new GameMenuView();
            gameMenuView.displayMenu();
        }
        else {
            System.out.println("What do you mean? Enter yes or no.");
        }
            
    }

    private void displayStoryline() {
        System.out.println("\n\n*************************************************");
        
        System.out.println("\n\n*                 Miracle Max                    *");
        
        System.out.println("*                                               *"
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
        );
        
        System.out.println("\n\n*************************************************");
    }


    public void displayIngredientList () {
        int ingredients = 1;
        char selection = ' ';
        double neededVolume;
        double addedVolume;
        int radius = 0;
        int height = 0;
        
        SceneControl miracleMaxControl = new SceneControl();
        
        while (ingredients < 4) {
            System.out.println(RECIPE);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            //get the amount needed for the recipe
            neededVolume = this.findNeededVolume(selection);
            
            //get the inputs for radius and height from the player
            System.out.println("To add the ingredients to the recipe you must first tell Miracle Max the radius and height of the measuring cup you need. There can be many combinations as long as the calculate to the correct volume.");
            System.out.println("Enter the radius needed:");
            radius = this.getNumInput();
            System.out.println("Enter the height needed:");
            height = this.getNumInput();
            
            //calculate the volume added by the player from the inputs
            addedVolume = miracleMaxControl.calculateIngredientVolume(radius, height);
            
            //compare the amount added to the amount needed
            if (addedVolume == neededVolume){
                ingredients = ++ingredients;
            }
            else {
               System.out.println("You rush a miracle man, you get rotten miracles. You added the wrong amount of ingredient, try again!");
               this.displayDefeatMenu();
               break;
            }
        }
        
    }
    
    private String getInput() {
        boolean valid = false;
        String selection = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            System.out.println("Select an ingredient to add from the recipe:");
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() > 1 || selection.length() < 1){
                System.out.println("Inconcievable! Please select an option from the recipe.");
                continue;
            }
            break;
        }
        return selection;
    }
    
    private double findNeededVolume(char selection) {
        double neededVolume = 0.0;
        switch (selection) {
            case '1':
                neededVolume = 2.0;
            case '2':
                neededVolume = 0.5;
            case '3':
                neededVolume = 1.0;
            case '4':
                neededVolume = 3.0;
            case 'E':
                break;
            default:
                System.out.println("\nInconceivable! Please select an option from the recipe.");
                break;
        }
        return neededVolume;
    }

    private int getNumInput() {
        boolean valid = false;
        int input = 0;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            
            input = keyboard.nextInt();
            break;
        }
        return input;    }

    private void displayDefeatMenu() {
        DefeatMenuView defeatMenu = new DefeatMenuView();
        defeatMenu.displayMenu();
    }
}
