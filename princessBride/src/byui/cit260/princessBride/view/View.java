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
public abstract class View implements ViewInterface {
    
    private final String promptMessage;
    
    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
     public void display () {
        char selection = ' ';
        do {
            System.out.println(this.promptMessage);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
        } while (selection != 'E');
    }
    
    @Override
    public String getInput() {
        boolean valid = false;
        String selection = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            System.out.println("Select an option from the Menu:");
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() > 1 || selection.length() < 1){
                System.out.println("Inconcievable! Please select an option from the Menu.");
                continue;
            }
            break;
        }
        return selection;
    }

    public int getNumInput() {
        boolean valid = false;
        int input = 0;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid) {
            input = keyboard.nextInt();
            break;
        }
        return input;
    }
 }


