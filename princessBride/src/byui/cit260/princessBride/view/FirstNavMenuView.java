/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public class FirstNavMenuView extends View {
   
    public FirstNavMenuView() {
       super("\n-------------------------------------------------"
            +"\n| Navigation Menu                               |"
            +"\n-------------------------------------------------"
            +"\nI - Journey to Inigo's grotto"
            +"\nF - Go to Fezzik's challange"
            +"\nV - Try your luck at Vizzini's poison puzzle"
            +"\nE - Exit the menu"
            +"\n-------------------------------------------------");
    }
    public void doAction(char selection){
        switch (selection) {
            case 'I':
                this.inigoView();
                break;
            case 'F':
                this.fezzikView();
                break;
            case 'V':
                this.vizziniView();
                break;
            case 'E':
                return;
            default:
                System.out.println("\nInconceivable! Please select an option from the Menu.");
                break;
        }
    
    }
        public String getNavChoice() {
        boolean valid = false; //indicates the navChoice has not been retrived
        String navChoice = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            
            System.out.println("Choose a location to explore");
            
            navChoice = keyboard.nextLine();
            navChoice = navChoice.trim();
            
            if (navChoice.length() < 1 || navChoice.length() > 1) {
                System.out.println("Inconceivable!  Please enter Menu selection");
                continue;
            }
            break;
        }
        
        return navChoice;
        }
  
  
         
         private void inigoView() {
        System.out.println("inigoView function called");
         }
         private void fezzikView() {
        System.out.println("fezzikView function called");
    }
          private void vizziniView() {
        System.out.println("vizziniView function called");
}     
}

