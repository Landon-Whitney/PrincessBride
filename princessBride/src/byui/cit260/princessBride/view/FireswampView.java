/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.SceneControl;
import byui.cit260.princessBride.model.Scene;

/**
 *
 * @author Robbie
 */

public class FireswampView extends View {

    private final String PLAYERSCHOICE = "\n"              
                +"\n------------------------------------------------"
                +"\n Part of being careful is choosing the right    "
                +"\n item.  Based on what you have seen or heard,   "
                +"\n type in a letter to make a choice:             "
                +"\n                                                "
                +"\n G - the goblet of water you got from Vizzini   "
                +"\n B - the bag of rocks from Fezzik               "
                +"\n R - the rope from Inigo                        "
                +"\n------------------------------------------------";
    
    public FireswampView(){
    
            super("\n"
                + "\n***************************************************"
                + "\n*               The Fire Swamp                    *"
                + "\n*                                                 *"
                + "\n* You are so happy to be reunited with Buttercup, *"
                + "\n* But danger approaches!  The evil Prince         *"
                + "\n* Humperdink has followed you!  You roll down     *"
                + "\n* a hill and run into the Fire Swamp to seek      *"
                + "\n* safety.  But there are many dangers in the      *"
                + "\n* fireswamp.  Many have entered, none have        *"
                + "\n* come out....Be very careful in there.           *"
                + "\n***************************************************"
                + "\n\n Will you enter the Fire Swamp? "
                + "\nEnter Y or N");
    }     
                
    public void doAction(char selection){
       switch (Character.toUpperCase(selection)) {
            case 'Y':
                this.fireswampChallenge();
                break;
            case 'N':
                super.console.println("As you wish.");
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from the Menu.");
                break;
        }
    }
    private void fireswampChallenge(){
        int g = 0;
        
        
        
        for(int i = 0; i < 5; i++){
            super.console.println(PLAYERSCHOICE);
            
            SceneControl swampChallenge = new SceneControl();
            int result = swampChallenge.createSwampChallenge();
            String playersSelection;
            
        
        
        
        if(result<=3){
            super.console.println("You hear a noise in the bushes!  Hurry! What item do you choose?");
            playersSelection = super.getInput();
            char charSelection = playersSelection.charAt(0);
            
            
            switch (Character.toUpperCase(charSelection)){
                case 'G':
                    super.console.println("You just threw water on an angry ROUS!  You were devoured.");
                    i = 5;
                    g++;
                    DefeatMenuView defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                    break;
                    
                case 'B':
                    super.console.println("You pelted a ROUS with rocks from your bag you scared it away!");
                    break;
                    
                case 'R':
                    super.console.println("The ROUS is too strong to be tied up.  You were devoured.");
                    i = 5;
                    g++;
                    defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                    break;
                    
                default:
                    ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from your items.");
                    break;
                    
            }
        
        }
        else if(result<=6){
            super.console.println("You hear a strange popping noise.  Which item do you choose?");
            playersSelection = super.getInput();
            char charSelection = playersSelection.charAt(0);
            
            
            switch (Character.toUpperCase(charSelection)){
                case 'G':
                    super.console.println("You use the water from the cup to douse the flames from a flame spurt.  Your quick thinking put out the flame spurt!  You survived!");
                    break;
                    
                case 'B':
                    super.console.println("Now not only is your hair on fire but your bag of rocks is too!  You died.");
                    i=5;
                    g++;
                    DefeatMenuView defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                    break;
                    
                case 'R':
                    super.console.println("Does burning a rope at both ends help here?  No, you died.");
                    i = 5;
                    g++;
                    defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                    break;
                    
                default:
                    ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from your items.");
                    break;
            }
        }
        else{
            super.console.println("The sandy ground suddenly gives out under the Princess!  What item to you choose?"); 
            playersSelection = super.getInput();
            char charSelection = playersSelection.charAt(0);
            
            
            switch (Character.toUpperCase(charSelection)){
                case 'G':
                    super.console.println("Pouring water on the lightning sand did not grow a new Princess.  You failed.");
                    i = 5;
                    g++;
                    DefeatMenuView defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                    break;
                    
                case 'B':
                    super.console.println("The rocks from your bag sink into the sand but do not help rescue the Princess.  You loose.");
                    i = 5;
                    g++;
                    defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                    break;
                    
                case 'R':
                    super.console.println("Quickly you tie the rope around a conveniently close tree and you dive in after Buttercup.  She is saved!");
                    break;
                   
                  default:
                    ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from your items.");
                    break;                  
            }
        }
        
        }
        if (g == 0) {
            super.console.println("You have survived the Fireswamp!!");
            Scene.Fireswamp.setCompleted(Boolean.TRUE);
        }
    }
    
            

   
        
        
        
    }

    
    
    
    
