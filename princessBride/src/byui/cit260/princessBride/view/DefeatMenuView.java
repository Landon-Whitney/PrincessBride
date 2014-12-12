/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;


/**
 *
 * @author whitneydavis
 */
public class DefeatMenuView extends View{
    public DefeatMenuView() {
            super("\nYou have failed to defeat the challenge!"
            + "\nNeed help? Check the help menu.        "
            + "\n"
            + "\n---------------------------------------"
            + "\n            Defeat Menu                "
            + "\n---------------------------------------"
            + "\nS - Start game from last save          "
            + "\nM - Return to Main Menu                "
            + "\nE - Return to Game Menu                "
            + "\n---------------------------------------");
    }

    public void doAction(char selection) {
        switch (selection) {
            case 'S':
                MainMenuView savedGame = new MainMenuView();
                savedGame.startExistingGame();
                break;
            case 'M':
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.displayMenu();
                break;
            case 'E':
                //GameMenuView gameMenu = new GameMenuView();
                //gameMenu.displayMenu();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from the Defeat Menu.");
                break;
        }

    }
}

