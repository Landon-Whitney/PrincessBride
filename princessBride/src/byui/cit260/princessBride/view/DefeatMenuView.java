/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import java.util.Scanner;

/**
 *
 * @author whitneydavis
 */
public class DefeatMenuView {
    private final String MENU = "\n"
            + "\n---------------------------------------"
            + "\n             Defeat Menu               "
            + "\n---------------------------------------"
            + "\nS - Start game from last save          "
            + "\nM - Return to Main Menu                "
            + "\nE - Exit                               "
            + "\n---------------------------------------";
    
    public void displayMenu(){
        System.out.println("You've failed to defeat the challenge!");
        
        char selection = ' ';
        do {
            System.out.println(MENU);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
        } while (selection != 'E');
    }
    
    private String getInput() {
        boolean valid = false;
        String selection = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            System.out.println("Select an option from the Main Menu:");
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() > 1 || selection.length() < 1){
                System.out.println("Inconcievable! Please select an option from the Main Menu.");
                continue;
            }
            break;
        }
        return selection;
    }
    
    private void doAction(char selection) {
        switch (selection) {
            case 'S':
                this.restartGame();
                break;
            case 'M':
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMenu();
                break;
            case 'E':
                return;
            default:
                System.out.println("\nInconceivable! Please select an option from the Defeat Menu.");
                break;
        }
}

    private void restartGame() {
        System.out.println("restartGame stub function called");
    }
}
