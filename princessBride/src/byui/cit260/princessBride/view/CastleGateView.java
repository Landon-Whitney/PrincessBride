/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.InventoryItem;
import princessbride.PrincessBride;

/**
 *
 * @author whitneydavis
 */
public class CastleGateView extends View{

    public CastleGateView() {
        super("\n\nLet me explain."
        + "\n"
        + "\nNo, there is too much. Let me sum up. Buttercup is marrying Humperdink"
        + "\nin little less than half an hour. So all we have to do is get in, break"
        + "\nup the wedding, steal the princess, make our escape...after I kill "
        + "\nCount Rugen. There is but one working castle gate, and...and it is "
        + "\nguarded by 60 men."
        + "\n"
        + "\nYou must get through the castle gate using your brains, Inigos steel,"
        + "\nand Fezzicks strength. Oh and whatever you happen to have in your pocket."
        + "\n"
        + "\nWill you accept this challenge?"
        + "\n(Enter Y or N)"
        );
    }

    @Override
    public void doAction(char selection) {
        switch (selection){
            case 'Y':
                this.castleGateChallenge();
            case 'N':
                super.console.println("As you wish");
                break;
            default:
                super.console.println("Please answer yes or no.");
                break;
        }   
    }

    private void castleGateChallenge() {
        //display inventory menu
        this.displayInventoryMenu();
        //prompt player for inventory selection
        this.console.println("What object will you use to fight off the 60 men?");
        String selection = this.getInput();
        char charSelection = selection.charAt(0);
        //check for action
        this.resultAction(charSelection);
    }

    private void displayInventoryMenu() {
        Game game = PrincessBride.getCurrentGame();
        InventoryItem[] inventoryList = game.getInventoryList();
        for (InventoryItem item: inventoryList){
            if (item.getQuantity()>0){
                int g = 1;
                this.console.println("\n" + g);
                this.console.println(item);
                g++;
            }
        }
    }

    private void resultAction(char charSelection) {
        switch (charSelection){
            case '1': 
            case '2':
            case '3':
            case '4':
            case '5':
                
        }
    }
    
}
