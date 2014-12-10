/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.control.SceneControl;
import byui.cit260.princessBride.model.Scene;

/**
 *
 * @author whitneydavis
 */
public class FezzicksChallengeView extends View {
    private final String GAMEMENU = "\n"
            + "\n----------------------------------------------------------"
            + "\nR - Rock "
            + "\nP - Paper "
            + "\nS - Scissors"
            + "\n----------------------------------------------------------";
    
    public FezzicksChallengeView() {
        super("\n\n***********************************************************"
                + "\n*                  Fezzicks Challenge                     *" 
                + "\n*                                                         *"
                + "\n* We must face each other as God intended. Sportsman like.*"
                + "\n* No tricks, no weapons, skill against skill alone. It's  *"
                + "\n* not my fault being the biggest and the strongest. I     *"
                + "\n* don't even exercise. I challenge you to a competition of*"
                + "\n* Rock, Paper, Scissors. Best two out of three wins!      *"
                + "\n*                                                         *"
                + "\n* Will you accept this challenge from Fezzick?            *"
                + "\n* (Enter Y or N)                                          *"
                + "\n***********************************************************");
}
    
    public void doAction(char selection) {
        switch (Character.toUpperCase(selection)) {
            case 'Y':
                this.fezzickChallenge();
                break;
            case 'N':
                super.console.println("As you wish.");
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from the Main Menu.");
                break;
        }
    }

    private void fezzickChallenge() {
        String playerSelection;
        int[] score;
        score = new int[3];
        int sum;
        
        for (int i = 0; i < 3; i++){
            super.console.println(GAMEMENU);
            playerSelection = super.getInput();
            char charSelection = playerSelection.charAt(0);
            Character.toUpperCase(charSelection);
            
            SceneControl scoreArray = new SceneControl();
            score = scoreArray.createScoreArray(score, i);
            
            if (score[i] == 1) {
                switch (charSelection) {
                    case 'R':
                        super.console.println("\nFezzick has played scissors and lost!\nI just want you to feel you are doing well. I don't want people to die embarrassed.");
                        break;
                    case 'P':
                        super.console.println("\nFezzick has played rock and lost!\nI just want you to feel you are doing well. I don't want people to die embarrassed.");
                        break;
                    case 'S':
                        super.console.println("\nFezzick has played paper and lost!\nI just want you to feel you are doing well. I don't want people to die embarrassed.");
                        break;
                }
            }
            else if (score[i] == 0) {
                switch (charSelection) {
                    case 'R':
                        super.console.println("\nFezzick has played paper and won!\nIt's not my fault being the biggest and the strongest; I don't even exercise.");
                        break;
                    case 'P':
                        super.console.println("\nFezzick has played scissors and won!\nIt's not my fault being the biggest and the strongest; I don't even exercise.");
                        break;
                    case 'S':
                        super.console.println("\nFezzick has played rock and won!\nIt's not my fault being the biggest and the strongest; I don't even exercise.");
                        break;
                }
            }
        }
        
        SceneControl scoreArray = new SceneControl();
        sum = scoreArray.winOrLose(score);
        
        if (sum > 2) {
            super.console.println("Congratulations, you've won against Fezzick!\nI just figured out why you give my so much trouble: I haven't fought one person in so long.");
            
            Scene.FezzicksChallenge.setCompleted(Boolean.TRUE);
            
            super.console.println("From Vizzini you've won a bottle of wine and a knife.");
            InventoryControl inventory = new InventoryControl();
            inventory.addItem("Knife");
            
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
        }
        else {
            super.console.println("You've been defeated by Fezzick!");
            DefeatMenuView defeatMenu = new DefeatMenuView();
            defeatMenu.display();
        }
            
    }
            
}

