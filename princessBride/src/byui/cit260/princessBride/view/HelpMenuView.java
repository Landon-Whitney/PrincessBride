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
public class HelpMenuView extends View{
    
    public HelpMenuView () {
            super("\n"
                    + "\n-------------------------------------------------"
                    + "\n                    Help Menu                    "
                    + "\n-------------------------------------------------"
                    + "\nG - What is the goal of the game?      "
                    + "\nM - How do I move around in the game?  "
                    + "\nB - How do I access blocked locations?"
                    + "\nF - What do I do if I fail a challenge?"
                    + "\nS - Can I leave the game and return to it later?"
                    + "\nP - How can I beat the Miracle Max challenge?"
                    + "\nE - Exit                             "
                    + "\n--------------------------------------------------");
    }
    
    private final String MIRACLEMAXHELP = "\n\n**************************************************"
            + "\n*              Miracle Max Help                  *"
            + "\n*                                                *"
            + "\n* In the Miracle Max challenge, you are asked to *"
            + "\n* mix the ingredients for a miracle pill by      *"
            + "\n* the necessary radius and height. This radius   *"
            + "\n* and height should be integers the give the     *"
            + "\n* volume in the listed recipe. The volume can be *"
            + "\n* calculated with the formula: V = pi * r^2 * h. *"
            + "\n* Use the numbers 5, 6, 55, and 66 to come up the*"
            + "\n* correct volume.                                *"
            + "\n**************************************************";
    
    private final String BLOCKEDSCENESHELP = "\n\n**************************************************"
            + "\n*              Blocked Locations                 *"
            + "\n*                                                *"
            + "\n* Locations that are blocked are marked on the   *"
            + "\n* map with an X. New locations will become       *"
            + "\n* available as other scenes are completed by the *"
            + "\n* player. Winning challenges is the only way to  *"
            + "\n* open these blocked scenes.                     *"
            + "\n**************************************************";
    
  
    public void doAction(char selection) {
        switch (Character.toUpperCase(selection)) {
            case 'G':
                this.explainGameGoal();
                break;
            case 'M':
                this.explainMovement();
                break;
            case 'B':
                this.console.println(BLOCKEDSCENESHELP);
                break;
            case 'F':
                this.explainFailing();
                break;
            case 'S':
                this.explainSaveGame();
                break;
            case 'P':
                this.console.println(MIRACLEMAXHELP);
                break;
            case 'E':
                return;
            default:
                ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from the Help Menu.");
                break;
        }
    }

    private void explainGameGoal() {
        super.console.println("*************************************************");
        
        super.console.println("*                   Game Goals                  *");
        
        super.console.println("*                                               *"
                + "\n* This is the game Princess Bride Adventure.    *"
                + "\n* The objective of this game is to rescue the   *"
                + "\n* Princess Buttercup from the conniving Prince  *"
                + "\n* Humperdink. To do this you must complete all  *"
                + "\n* challenges, including facing the crew Inigo   *"
                + "\n* Fezzik, and Vizzini, defeating the ROUS's,    *"
                + "\n* surviving the Pit of Despair, and getting     *"
                + "\n* past the Castle Gate. Once you have finished  *"
                + "\n* all the other challenges, you will be able to *"
                + "\n* access Prince Humperdink's Maze, which you    *"
                + "\n* will then navigate to find Princess Buttercup *"
                + "\n* and gain loves true kiss!                     *"
        );
        
        super.console.println("*************************************************");
        

    }

    private void explainMovement() {
        super.console.println
                ("*****************************************************");
        
        super.console.println
                ("*                 Moving in the Game                *");
        
        super.console.println
                ("*                                                   *"
                + "\n* In this game, you can choose the order in         *"
                + "\n* which to complete the challenges. To do this,     *"
                + "\n* access Main Menu and choose option L - move to    *"
                + "\n* a new location. From there, you will put in the x *"
                + "\n* and y coordinates found in the map, which you can *"
                + "\n* also access from the main menu under 'View Map'.  *" 
        );
        
        super.console.println
                ( "*****************************************************");    
    }

    private void explainFailing() {
        super.console.println("**************************************************");
        
        super.console.println("*                 Failing the Game               *");
        
        super.console.println("*                                                *"
                + "\n* If you fail a challenge, the Defeat Menu is    *"
                + "\n* displayed. This menu will ask you whether you  *"
                + "\n* would like to start with the last save or quit *"
                + "\n* the game and return to it later. All           *"
                + "\n* challenges can be repeated as many times as    *"
                + "\n* necessary.                                     *"
        );
        
        super.console.println("**************************************************"); 
    }

    private void explainSaveGame() {
        super.console.println("*************************************************");
        
        super.console.println("*                 Saving the Game               *");
        
        super.console.println("*                                               *"
                + "\n* At any point in game play, you may save the   *"
                + "\n* game in order to preserve your progress. This *"
                + "\n* can be done by accessing the Main Menu and    *"
                + "\n* selecting S for the save option.              *"
        );
        
        super.console.println("*************************************************");
    }
    
}
