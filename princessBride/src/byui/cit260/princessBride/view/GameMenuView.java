/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.GameControl;
import byui.cit260.princessBride.model.Item;

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
            case 'I': //view inventory
                this.viewInventory();
                break;
            case 'A': //view actors
                this.viewActors();
                break;
            case 'L': //move to a new location
                this.moveLocations();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewInventory() {
        //get the sorted list of inventory items for the current game
        Item[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Inventory Items");
        System.out.println("Description" + "\t" +
                            "Required" + "\t" +
                            "In Stock");
        
        //for each inventory item
        for (Item inventoryItem : inventory) {
            //DISPLAY the description, the required amount and amount in stock
            System.out.println(inventoryItem.getDescription());
        }
    }

    private void viewActors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void moveLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
