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
 * @author whitneydavis
 */
public class CastleMazeView extends View{
    private final String CONVERSATION = "\n\nPrince Humperdinck: First things first, to the _______.\n" +
                "Westley: No. To the _______. \n" +
                "Prince Humperdinck: I don't think I'm quite familiar with that phrase. \n" +
                "Westley: I'll explain and I'll use small words so that you'll be sure to \n" +
                    "\tunderstand, you warthog faced buffoon. \n" +
                "Prince Humperdinck: That may be the first time in my life a man has dared \n" +
                    "\tinsult me. \n" +
                "Westley: It won't be the last. To the pain means the first thing you will\n" +
                    "\tlose will be your feet below the ankles. Then your hands at the wrists.\n" +
                    "\tNext your ______. \n" +
                "Prince Humperdinck: And then my tongue I suppose, I killed you too quickly\n" +
                    "\tthe last time. A mistake I don't mean to duplicate tonight. \n" +
                "Westley: I wasn't finished. The next thing you will lose will be your left\n" +
                    "\teye followed by your right. \n" +
                "Prince Humperdinck: And then my ears, I understand let's get on with it. \n" +
                "Westley: WRONG. Your ears you keep and I'll tell you why. So that every ________\n"+
                    "\tof every child at seeing your hideousness will be yours to cherish. Every\n" +
                    "\tbabe that weeps at your approach, every woman who cries out, \"What is\n" +
                    "\tthat thing?\" will echo in your perfect ears. That is what to the pain\n" +
                    "\tmeans. It means I leave you in anguish, wallowing in freakish misery forever. \n" +
                "Prince Humperdinck: I think you're bluffing. \n" +
                "Westley: It's possible, Pig, I might be bluffing. It's conceivable, you miserable,\n" +
                    "\tvomitous mass, that I'm only lying here because I lack the strength to stand.\n" +
                    "\tBut, then again... perhaps I have the strength after all. \n" +
                "[slowly rises and points sword directly at the prince] \n" +
                "Westley: DROP... YOUR... ________! \n" +
                "Prince Humperdinck: [Humperdinck's mouth hangs open, drops sword to floor]";

    public CastleMazeView() {
        super("\n\nMawage. Mawage is wot bwings us togeder today. Mawage, that bwessed"
        + "\nawangment, that dweam wifin a dweam.  And wuv, tru wuv, will fowow "
        + "\nyou foweva. So tweasure your wuv."
        + "\n"
        + "\nYou've made it past the castle gate but now you must find Princess"
        + "\nButtercup within the maze that is the castle. Fill in the missing words"
        + "\nfrom the insults you throw at Prince Humperdink to find your way."
        + "\n"
        + "\nWill you accept this challenge?"
        + "\n(Enter Y or N)"
        );
    }

    @Override
    public void doAction(char selection) {
        switch (selection){
            case 'Y':
                this.castleMazeChallenge();
            case 'N':
                super.console.println("As you wish");
                break;
            default:
                super.console.println("Please answer yes or no.");
                break;
        }   
    }

    private void castleMazeChallenge() {
        //explain challenge
        this.console.println("\nFill in the blanks in the conversation with Prince"
                + "\nHumperdinck with words from the maze. The words will"
                + "\ncreate a path leading to Princess Buttercup.");
        //print maze and puzzle
        this.displayMaze();
        this.console.println(CONVERSATION);
        //get user selection
        String selectionArray[] = null;
        
        do{
            this.console.println("\n\nEnter your selected words separated by a comma that lead from START to END. You should have five selections:");
            String selection = this.getInput();
            selectionArray = selection.split(",");
            if (selectionArray.length != 5){
                ErrorView.display(this.getClass().getName(), "You must select five words that lead from the START to the END");
            }
        }while (selectionArray.length != 5);
            
        //compare user selection with right answer
        boolean correct = SceneControl.checkMazePath(selectionArray);
        if (correct){
            this.console.println("\nYou have chosen the right path and found your way to Princess Buttercup!");
            
            Scene.CastleGate.setCompleted(true);
            
            TrueLovesKissView endScene = new TrueLovesKissView();
            endScene.display();
        }
        else{
            this.console.println("\nThat was the wrong path.");
            DefeatMenuView defeat = new DefeatMenuView();
            defeat.display();
        }
    }

    private void displayMaze() {
        //create word array
        String wordArray[][] = SceneControl.createWordArray();
        //display title
        this.console.println("\n\nCastle Maze");
        //iterate through every row and column and display
        this.console.println("--------------------------------");
        for (int row = 0; row < 4; row++) {
            
            for (int column = 0; column < 4; column++) {
                this.console.print("|");
                //for every column display contained word
                this.console.print(wordArray[row][column]);
                //display ending column divider
                this.console.print("|");
            }
            //display ending row divider
            this.console.println("\n--------------------------------");
        }
    }

    
}
