/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.exceptions.SceneControlException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public class PitOfDespairView extends View{
    
 
    boolean levers[] = new boolean[5];
    //put an inital value on health
    int health = 100;
    
    
    
    public PitOfDespairView (){
            
                      super("\n*****************************************"
                        +"\n*             Pit of Despair             *"
                        +"\n*                                        *"
                        +"\n* You awake to find yourself in a lab.   *" 
                        +"\n* An albino servant informs you that     *"
                        +"\n* you are in the pit of despair, Prince  *"
                        +"\n* Humperdink's secret lab where he       *"
                        +"\n* experiements on humans.                *"
                        +"\n* You have five levers in front of you.  *"
                        +"\n* Each lever will take away or add       *"
                        +"\n* years to your life.  You must throw    *"
                        +"\n* all the levers and hope you escape!    *"
                        +"\n********************************************"
                        +"\n* Will you face the lever challenge? Y/N *"
                        +"\n********************************************");
    }
    @Override
    public void doAction(char selection) {
       switch (Character.toUpperCase(selection)){
           case 'Y':
                  this.pit();
                  break;
           case 'N':
               super.console.println("As you wish");
               break;
           default:
               ErrorView.display(this.getClass().getName(), "\nInconceivable!  Please select Y for yes or N for no");
               PitOfDespairView pitOfDespair = new PitOfDespairView();
               pitOfDespair.displayMenu();
        }
        
    }
    
    public void pit (){
        
        
        this.console.println("Choose a lever 1 through 5.  Use each lever once.");
        //use a scanner to recieve player input
        Scanner userInput = new Scanner(System.in);
   
        do {
            //a try /catch that will catch a user letter
            try{
                health += leverPull(userInput.nextInt());
                
           } catch (InputMismatchException IME){
                ErrorView.display(this.getClass().getName(), "\nNot a number!  Please put in a number between 1-5\n");
                userInput.next();
           }
                
        this.console.println("Your health is "+ health);
        }while ((!levers[0] || !levers[1] || !levers[2] || !levers[3] || !levers[4]) && health > 0);
        
        if(health < 0){
            this.console.println("You died!");
            this.displayDefeatMenu();
        } 
        else if(health < 1){
            this.console.println("You got so healthy that Prince Humperdink had to kill you!");
            this.displayDefeatMenu();
        }
        else
            this.console.println("You survived the Pit of Despair by by becoming mostly dead.");
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }
    
public int leverPull(int leverChoice){        
    
    int healthChange = 0;
    
        if(leverChoice == 1 && !levers[0]){
            healthChange = -35;
           levers[0] = true;
            }  
            else if(leverChoice == 2 && !levers[1]){
                healthChange = 15;
                levers[1] = true;
            }
            else if(leverChoice == 3 && !levers[2]){
                healthChange = -65;
                levers[2] = true;
            }
            else if(leverChoice == 4 && !levers[3]){
                healthChange = -20;
                levers[3] = true;
            }
            else if(leverChoice == 5 && !levers[4]){
                healthChange = 6;
                levers[4] = true;
            } 
            else
                ErrorView.display(this.getClass().getName(), "Inconcievable! Enter a number between 1 and 5 that you haven't pulled.");
        return healthChange;
}

  
    private void displayDefeatMenu() {
        DefeatMenuView defeatMenu = new DefeatMenuView();
        defeatMenu.displayMenu();
    }
}
