/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.control.MapControl;
import byui.cit260.princessBride.exceptions.MapControlException;
import byui.cit260.princessBride.model.Actor;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import java.io.IOException;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class GameMenuView extends View {
    public GameMenuView() {
        super("\n"
            + "\n-------------------------------------"
            + "\n              Game Menu              "
            + "\n-------------------------------------"
            + "\nM - View map"
            + "\nI - View inventory"
            + "\nP - Print inventory list"
            + "\nA - View list of actors"
            + "\nL - Move to a new location"
            + "\nH - Help menu"
            + "\nE - Exit and return to Main Menu"
            + "\n-------------------------------------");
    }
    
    public void doAction(char selection) {
        switch (Character.toUpperCase(selection)) {
            case 'M': //view map
                this.displayMap();
                break;
            case 'I': //view inventory
                this.viewInventory();
                break;
            case 'P': //print inventory list
                try {
                    this.printInventory();
                    break;
                }catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());
                }
            case 'A': //view actors
                this.viewActors();
                break;
            case 'L': 
                try {
                    //move to a new location
                    this.moveLocations();
                } catch (MapControlException ex) {
                    ErrorView.display(this.getClass().getName(), "Error reading input: "+ ex.getMessage());
                }
                break;
            case 'H'://display help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.display();
            case 'E':
                return;
            default:
                ErrorView.display(this.getClass().getName(), "\nInconceivable! Please select an option from the Game Menu.");
                break;
        }
    }

    private void displayMap() {
        //get the map locations from the current game
        Map currentMap = PrincessBride.getCurrentGame().getMap();
        //display title
        this.console.println("Princess Bride Game Map");
        //iterate through every row and column and display
        Location locations[][] = currentMap.getLocations();
        this.console.println("\n     0    1    2   ");
        this.console.println("--------------------");
        for (int row = 0; row < locations.length; row++) {
            
            this.console.print(row + "  ");
            
            for (int column = 0; column < locations[row].length; column++) {
                this.console.print("|");
                //check if location is blocked
                MapControl.checkBlockedLocations();
                //for every column display description if location is not blocked and X if it is
                if (!locations[row][column].getScene().getBlocked()) {
                    this.console.print(locations[row][column].getScene().getShortDescription());
                }
                else {
                    this.console.print(" X ");
                }
                //display ending column divider
                this.console.print("|");
            }
            //display ending row divider
            this.console.println("\n--------------------");
        }
        for (int row = 0; row < locations.length; row++){
          for (int column = 0; column < locations[row].length; column++){
              if (!locations[row][column].getScene().getBlocked()) {
                    String description = locations[row][column].getScene().getDescription();
                    String shortDes = locations[row][column].getScene().getShortDescription();
                    String name = locations[row][column].getScene().getName();
                    this.console.println(shortDes + ": " + name + ", " + description);
                }
          }  
        }
        this.console.println("X: blocked location and scene");
    }

    private void viewInventory() {
        //get the sorted list of inventory items for the current game
        InventoryItem[] inventoryList = InventoryControl.getSortedInventoryList();
        //print out title
        String title = "Inventory List";
        this.console.println(title);
        //print out column headings
        String catagories = "\n\n\nName\t\tDescription\t\tQuantity\n";
        this.console.println(catagories); //http://stackoverflow.com/questions/6000810/printing-with-t-tabs-does-not-result-in-aligned-columns
        //iterate through and print out each item
        for (InventoryItem inventoryItem: inventoryList){
            String description = inventoryItem.getDescription();
            double quantity = inventoryItem.getQuantity();
            
            this.console.println("\n" + inventoryItem + "\t\t" + description + "\t\t   " + quantity);
        }

    }

    private void viewActors() {
        
        this.console.println("\nActors in the Game");
        
        this.console.println(Actor.Fezzick.toString());
        this.console.println(Actor.Inigo.toString());
        this.console.println(Actor.Miracle_Max.toString());
        this.console.println(Actor.Prince_Humperdink.toString());
        this.console.println(Actor.Princess_Buttercup.toString());
        this.console.println(Actor.Vizzini.toString());   
     
    }

    private void moveLocations() throws MapControlException {
        
        this.console.println("Enter the row number of your destination: ");
        int row = super.getNumInput();
        
        this.console.println("Enter the column number of your destination: ");
        int column = super.getNumInput();
        
        MapControl.movePlayerToLocation(row, column);
    }

    private void printInventory() throws IOException {
        //get filepath from user
        String filePath = this.getFileInput();
        //call another view layer to print report
        PrintView report = new PrintView();
        report.printInventory(filePath);
        //display success message if report was printed
        this.console.println("The inventory report has been printed to the " + filePath + " file path.");

    }
}
