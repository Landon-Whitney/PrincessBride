/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public abstract class View implements ViewInterface {
    
    final String promptMessage;
    protected final BufferedReader keyboard = PrincessBride.getInFile();
    protected final PrintWriter console = PrincessBride.getOutFile();
    
    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
     public void display () {
        char selection = ' ';
        do {
            this.console.println(this.promptMessage);
            
            String input = this.getInput();
            //this.console.println(input);
            selection = input.charAt(0);
            
            this.doAction(selection);
        } while (selection != 'E');
    }
    
    @Override
    public String getInput() {
        boolean valid = false;
        String selection = null;
        try {
        
        while (!valid) {
            this.console.println("Select an option from the Menu:");
            
            
            selection = this.keyboard.readLine();
            selection = selection.trim();
            
            if (selection.length() > 1 || selection.length() < 1){
                ErrorView.display(this.getClass().getName(),"Inconcievable! Please select an option from the Menu.");
                continue;
            }
            break;
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return selection;
    }

    public int getNumInput() {
        Integer number = null;
        while (number == null){
            String value = this.getInput();
            value = value.trim().toUpperCase();
        try{
            number = Integer.parseInt(value);
        }catch (NumberFormatException nf) {
            
            this.console.println("\n You must enter a valid number.");
        }
        }
        return number;
    }
 }


