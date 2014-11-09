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
public class HelpMenuView extends View{
    
    public HelpMenuView () {
            super("\n"
            + "\n---------------------------------------"
            + "\n               Help Menu               "
            + "\n---------------------------------------"
            + "\nG - What is the goal of the game?      "
            + "\nM - How do I move around in the game?  "
            + "\nF - What do I do if I fail a challenge?"
            + "\nS - Can I leave the game and return to it later?"
            + "\nE - Exit                             "
            + "\n---------------------------------------");
    }
    
    public void doAction(char selection) {
        switch (selection) {
            case 'G':
                this.explainGameGoal();
                break;
            case 'M':
                this.explainMovement();
                break;
            case 'F':
                this.explainFailing();
                break;
            case 'S':
                this.explainSaveGame();
                break;
            case 'E':
                return;
            default:
                System.out.println("\nInconceivable! Please select an option from the Help Menu.");
                break;
        }
    }

    private void explainGameGoal() {
        System.out.println("\n\n*************************************************");
        
        System.out.println("\n\n*                 Game Goals                    *");
        
        System.out.println("*                                               *"
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
                + "\n* will then navigate to find Princess Buttercup.*"
                + "\n* Once you have accomplished this, the game is  *"
                + "\n* complete!                                     *"
        );
        
        System.out.println("\n\n*************************************************");
        

    }

    private void explainMovement() {
        System.out.println("\n\n*************************************************");
        
        System.out.println("\n\n*                 Moving in the Game            *");
        
        System.out.println("*                                               *"
                + "\n* In this game, you can choose the order in     *"
                + "\n* which to complete the challenges. To do this, *"
                + "\n* access the Game Control Menu throug the Main  *"
                + "\n* Menu, and select the Move Option. From there, *"
                + "\n* choose the location you would like to access. *"
        );
        
        System.out.println("\n\n*************************************************");    
    }

    private void explainFailing() {
        System.out.println("\n\n*************************************************");
        
        System.out.println("\n\n*                 Failing the Game              *");
        
        System.out.println("*                                               *"
                + "\n* If you fail a challenge, the Defeat Menu is   *"
                + "\n* displayed. This menu will ask you whether you *"
                + "\n* would like to start with the last save or quit*"
                + "\n* the game and return to it later. All          *"
                + "\n* challenges can be repeated as many times as   *"
                + "\n* necessary.                                    *"
        );
        
        System.out.println("\n\n*************************************************"); 
    }

    private void explainSaveGame() {
        System.out.println("\n\n*************************************************");
        
        System.out.println("\n\n*                 Saving the Game               *");
        
        System.out.println("*                                               *"
                + "\n* At any point in game play, you may save the   *"
                + "\n* game in order to preserve your progress. This *"
                + "\n* can be done by accessing the Main Menu and    *"
                + "\n* selecting S for the save option.              *"
        );
        
        System.out.println("\n\n*************************************************");
    }
    
}
