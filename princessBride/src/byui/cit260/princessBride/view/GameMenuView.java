/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.control.MapControl;
import byui.cit260.princessBride.exceptions.MapControlException;
import byui.cit260.princessBride.model.Actor;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Item;
import byui.cit260.princessBride.model.Location;
import byui.cit260.princessBride.model.Map;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            + "\nF - Go to Fezzick's Challenge"
            + "\nI - View inventory"
            + "\nA - View list of actors"
            + "\nL - Move to a new location"
            + "\nH - Help menu"
            + "\nQ - Quit"
            + "\n-------------------------------------");
    }
    
    public void doAction(char selection) {
        switch (selection) {
            case 'M': //view map
                this.displayMap();
                break;
            case 'F': //go to fezzick's challenge
                FezzicksChallengeView fezzicksChallenge = new FezzicksChallengeView();
                fezzicksChallenge.display();
            case 'I': //view inventory
                this.viewInventory();
                break;
            case 'A': //view actors
                this.viewActors();
                break;
            case 'L': {
            try {
                //move to a new location
                this.moveLocations();
            } catch (MapControlException ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 'H'://display help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.display();
            case 'Q':
                return;
            default:
                System.out.println("\nInconceivable! Please select an option from the Game Menu.");
                break;
        }
    }

    private void displayMap() {
        //get the map locations from the current game
        Map currentMap = PrincessBride.getCurrentGame().getMap();
        //display title
        System.out.println("Princess Bride Game Map");
        //iterate through every row and column and display
        Location locations[][] = currentMap.getLocations();
        System.out.println("\n     0    1    2   ");
        System.out.println("--------------------");
        for (int row = 0; row < locations.length; row++) {
            
            System.out.print(row + "  ");
            
            for (int column = 0; column < locations[row].length; column++) {
                System.out.print("|");
                
                
                //for every column display description if location is not blocked and X if it is
                if (!locations[row][column].getScene().getBlocked()) {
                    System.out.print(locations[row][column].getScene().getShortDescription());
                }
                else {
                    System.out.print(" X ");
                }
                //display ending column divider
                System.out.print("|");
            }
            //display ending row divider
            System.out.println("\n--------------------");
        }
    }

    private void viewInventory() {
        //get the sorted list of inventory items for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Inventory Items");
        System.out.println("Description" + "\t" +
                            "Required" + "\t" +
                            "In Stock");
        
        //for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            //DISPLAY the description, the required amount and amount in stock
            System.out.println(inventoryItem.getDescription());
        }
    }

    private void viewActors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void moveLocations() throws MapControlException {
        
        System.out.println("Enter the x coordinate of your destination: ");
        int row = super.getNumInput();
        
        System.out.println("Enter the y coordinate of your destination: ");
        int column = super.getNumInput();
        
        MapControl.movePlayerToLocation(row, column);
        //Actor [] actor;
        //Point coordinates;
        //try {
           // MapControl.moveActorToLocation(actor, coordinates);
            
        //}catch (MapControlException me){
            //System.out.println(me.getMessage());
       // }
    }
}
