/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.ProgramControl;
import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class StartProgramView extends View {

    public StartProgramView() {
        super(
                "\n              Princess Bride Adventure              "
                + "\n****************************************************"
                + "\n* This is the game Princess Bride Adventure.       *"
                + "\n* Buttercup has found her true love in Westley,    *"
                + "\n* the farm boy. Without any money, Westley         *"
                + "\n* travels to the sea to seek his fortune, with     *"
                + "\n* with a plan to come back for her, his true       *"
                + "\n* love.  Westley's ship was attacked by the        *"
                + "\n* Dread Pirate Robert, who never leaves survivors. *"
                + "\n* Meanwhile the evil Prince Humperdink announces   *"
                + "\n* his engagement to Princess Buttercup who did not *"
                + "\n* love him.  While riding her horse Buttercup is   *"
                + "\n* kidnapped by a group of 'circus workers' who are *"
                + "\n* trying to start a war between countries.         *"
                + "\n****************************************************"
                + "\n\nWould you like to play the game? Enter Y or N"
             );
    }


    @Override
    public void doAction(char value) {
        
        if (value == 'N') {
            return;
        }
        
        String playersName = this.getPlayersName();
        // Create a new player 
        Player player = ProgramControl.createPlayer(playersName);
        // DISPLAY a customized welcome message 
        this.displayWelcomeMessage(player);
        PrincessBride.setPlayer(player);
        // DISPLAY the main menu 
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    }


   
    public String getPlayersName() {
        boolean valid = false; //indicates the name has not been retrived
        String playersName = null;
        
        try{
        while (!valid) {
            
            this.console.println("Who dares to rescue Princess Buttercup? Enter the players name below:");
            
            playersName = this.keyboard.readLine();
            playersName = playersName.trim();
            
            if (playersName.length() < 1) {
                this.console.println("Inconceivable!  Please enter your name:");
                continue;
            }
            break;
        }
        } catch(Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return playersName;
        
    }
    
    private void displayWelcomeMessage(Player player) {
        this.console.println("\n\n==================================================="
            + "\t\n Good luck, Dread Pirate " + player.getName()
            +"\t\n We hope you will have a lot of fun!"
            +"\n===================================================");
    }
    
    
}

