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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberta
 */
public class InigosGrottoView extends View{

    
    public InigosGrottoView(){
        
        super("\n"
                + "\n-----------------------------------------------------------"
                + "\n As you race to Princess Buttercup's aid, you meet up with "
                + "\n an agile man named Inigo.  He is one of the hired thugs    "
                + "\n who kidnapped her!  He says that he is saving the blade   "
                + "\n that his father made for another and if you can beat him  "
                + "\n in a rhyming game, he will tell you where Princess        "
                + "\n Buttercup is being held.                                  "
                + "\n-----------------------------------------------------------"
                + "\n The rhyming battle works like this: Inigo will give you   "
                + "\n a word and he will tell you how many words that he knows  "
                + "\n that rhymes with it.  You tell him as many words as you   "
                + "\n can that rhyme with his word, each word followed by       "
                + "\n pressing enter.  When you can't think of another word,    "
                + "\n just leave the answer blank and press enter.  You will    "
                + "\n get one point for every word that you know that rhymes.   "
                +"\n Would you like to play Inigo's game? Y/N                   "
        );
        //this.console.println(this.promptMessage);
        
    
    }

    @Override
    public void doAction(char value) {
        switch (Character.toUpperCase(value)){
            case 'Y':
                double average = 0;
                while(average < 8){
                    SceneControl inigosGrottoControl = new SceneControl();
                    int score = inigosGrottoControl.checkPlayerRhymingWord();
            try {
                average = inigosGrottoControl.computerRhymingWord(score);
            } catch (SceneControlException ex) {
                ErrorView.display(this.getClass().getName(),"Error reading input:"+ ex.getMessage());
            }
            
            if (average >= 8){
                    this.console.println("your average score is: " + average + " You win!" );
                    Scene.InigosGrotto.setCompleted(Boolean.TRUE);
                    
                    this.console.println("Inigo gives you a coil of rope to help you. \nIt has been added to your inventory.");
                    InventoryControl inventory = new InventoryControl();
                    inventory.addItem("Rope");           
                    
            }
                    else {
                    
                    this.console.println(" You did not find enough words, try again.");
                    
                    DefeatMenuView defeatMenu = new DefeatMenuView();
                    defeatMenu.displayMenu();
                            
                            }
                }
            break;
            case 'N':
                this.console.println("As you wish.");

                break;
            default:
                ErrorView.display(this.getClass().getName(), "Please print Y or N");
                break;
        }
        
    }
    
}
