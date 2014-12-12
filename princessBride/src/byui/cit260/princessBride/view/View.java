/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
        this.console.println(this.promptMessage);
        this.console.println("Select an option: ");
        String input = this.getInput();
        //this.console.println(input);
        selection = input.charAt(0);
            
        this.doAction(selection);
    }
     
     public void displayMenu () {
        char selection = ' ';
        do {
            this.console.println(this.promptMessage);
            this.console.println("Select an option: ");
            String input = this.getInput().toUpperCase();
            //this.console.println(input);
            selection = input.charAt(0);
            
            this.doAction(selection);
        } while (selection != 'E'&& selection != 'N');
    }
    
    @Override
    public String getInput() {
        boolean valid = false;
        String selection = null;
        try {
        
        while (!valid) {

            selection = this.keyboard.readLine();
            selection = selection.trim();
            
            if (selection.length() < 1){
                ErrorView.display(this.getClass().getName(),"Inconcievable! Please enter a valid selection.");
                continue;
            }
            else {
                break;
            }
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
                ErrorView.display(this.getClass().getName(), "\nError reading input: You must enter a valid number.");
            }
        }
        return number;
    }
    
    public String getFileInput() {
        boolean valid = false;
        String filePath = null;
        try {
        
        while (!valid) {
            this.console.println("Enter the filepath where the report will be printed:");
            
            filePath = this.keyboard.readLine();
            filePath = filePath.trim();
            
            if (filePath.length() < 1){
                ErrorView.display(this.getClass().getName(),"Inconcievable! Please enter a valid file path.");
                continue;
            }
            break;
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return filePath;
    }
 }


