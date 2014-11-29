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
public class DefeatMenuView extends View{
    public DefeatMenuView() {
            super("\nYou have failed to defeat the challenge!"
            + "\n"
            + "\n---------------------------------------"
            + "\n            Defeat Menu                "
            + "\n---------------------------------------"
            + "\nS - Start game from last save          "
            + "\nM - Return to Main Menu                "
            + "\nE - Exit                               "
            + "\n---------------------------------------");
    }

    public void doAction(char selection) {
        switch (selection) {
            case 'S':
                this.restartGame();
                break;
            case 'M':
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
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
