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
public class StartProgramView {
    
    public StartProgramView(){   
    }
    
    public void startProgram(){

        // Display the banner screen
        this.displayBanner();
        // Get the players name
        String playersName = this.getPlayersName();
        // Create a new player 
        // DISPLAY a customized welcome message 
        // DISPLAY the main menu 
 
    }

    public void displayBanner() {
        System.out.println("\n\n************************************************");
        
        System.out.println("*                                              *"
                + "\n*This is the game Princess Bride Adventure.    *"
                + "\n*Buttercup has found her true love in Westley, *"
                + "\n*farm boy. Without any money Westley travels   *"
                + "\n*");
        
        System.out.println("\n\n************************************************");
      
    }

    public String getPlayersName() {
        boolean valid = false; //indicates the name has not been retrived
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            
            System.out.println("Enter the players name below:");
            
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            if (playersName.length() < 1) {
                System.out.println("Invalid name - the name must not be blank");
                continue;
            }
            break;
        }
        
        return playersName;
        
        //getInput(): valueEntered;
        //BEGIN
            //WHILE valid value has been entered
                //DISPLAY a message prompting the user to enter another value   
                //GET the value entered from the keyboard, trim off front and trailing blanks
            
                //IF invalid value entered then
                    //DISPLAY invalid value message
                    //CONTINUE
                //ENDIF
            
                //BREAK
            //ENDWHILE
            //RETURN value entered
        //END
    }
}
