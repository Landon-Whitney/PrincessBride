/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.SceneControl;
import java.util.Scanner;

/**
 *
 * @author Roberta
 */
public class InigosGrottoView extends View{
    
    //public static void main (String args[]){  
    //    View test = new InigosGrottoView("");
    //    Scanner keyboard = new Scanner(System.in);
    //   test.doAction(keyboard.nextLine().charAt(0));
    //}
    
    public InigosGrottoView(){
        
        super("\n"
                + "\n-----------------------------------------------------------"
                + "\n As you race to Princess Buttercup's aid, you meet up with "
                + "\n a agile man named Inigo.  He is one of the hired thugs    "
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
        //System.out.println(this.promptMessage);
        
    
    }

    @Override
    public void doAction(char value) {
        switch (Character.toUpperCase(value)){
            case 'Y':
                SceneControl inigosGrottoControl = new SceneControl();
                inigosGrottoControl.checkPlayerRhymingWord();
                break;
            case 'N':
                System.out.println("As you wish.");
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
                break;
            default:
                System.out.println("Please print Y or N");
                break;
        }
    }
    
}
