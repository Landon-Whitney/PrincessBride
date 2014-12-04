   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.view.HelpMenuView;
import java.util.Scanner;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
        super("\n"
            + "\n-------------------------------------"
            + "\n              Main Menu              "
            + "\n-------------------------------------"
            + "\nN - Search anew for Buttercup        "
            + "\nB - Continue the search for Buttercup"
            + "\nH - Get help on how to play the game "
            + "\nS - Save game                        "
            + "\nE - Exit                             "
            + "\n-------------------------------------");
    }
    
    public void doAction(char selection) {
        switch (selection) {
            case 'N':
                this.startNewGame();
                break;
            case 'B':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':
                return;
            default:
                ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from the Main Menu.");
                break;
        }
    }

    private void startNewGame() {
        //create a new game
        GameControl.createNewGame(PrincessBride.getPlayer());
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        this.console.println("\n\nEnter the file path for file where the game is to be saved.");
        
        String filePath = this.getInput();
        
        try{
            GameControl.getSavedGame(filePath);
            
        }catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
       
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        
    }

    private void saveGame() {
        this.console.println("\n\nEnter the file path for file where the game "
                                + "is to be saved.");
        String filePath = this.getInput();
        
        try{
            GameControl.saveGame(PrincessBride.getCurrentGame(), filePath);
        }catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
}
