/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.control.InventoryControl;
import byui.cit260.princessBride.model.InventoryItem;
import byui.cit260.princessBride.model.Scene;

/**
 *
 * @author whitneydavis
 */
public class CastleGateView extends View{

    public CastleGateView() {
        super("\n\n-----------------------------------------------------------------------------"
        + "\n|                             Castle Gate                                   |"
        + "\n|                                                                           |"
        + "\n|Let me explain.                                                            |"
        + "\n|                                                                           |"
        + "\n|No, there is too much. Let me sum up. Buttercup is marrying Humperdink     |"
        + "\n|in little less than half an hour. So all we have to do is get in, break    |"
        + "\n|up the wedding, steal the princess, make our escape...after I kill         |"
        + "\n|Count Rugen. There is but one working castle gate, and...and it is         |"
        + "\n|guarded by 60 men.                                                         |"
        + "\n|                                                                           |"
        + "\n|You must get through the castle gate using your brains, Inigos steel,      |"
        + "\n|and Fezzicks strength. Oh, and whatever you happen to have in your pocket. |"
        + "\n|                                                                           |"
        + "\n|Will you accept this challenge?                                            |"
        + "\n|(Enter Y or N)                                                             |"
        + "\n-----------------------------------------------------------------------------"
        );
    }

    @Override
    public void doAction(char selection) {
        switch (selection){
            case 'Y':
                this.castleGateChallenge();
                break;
            case 'N':
                super.console.println("As you wish");
                break;
            default:
                super.console.println("Please answer yes or no.");
                CastleGateView gate = new CastleGateView();
                gate.display();
                break;
        }   
    }

    private void castleGateChallenge() {
        char charSelection;
        
        do {
        //display inventory menu
        this.displayInventoryMenu();
        //prompt player for inventory selection
        this.console.println("\nWhat object will you use to fight off the 60 men?");
        String selection = this.getInput();
        charSelection = selection.charAt(0);
        //check for action
        charSelection = this.resultAction(charSelection);
        } while (charSelection != '1');
    }

    private void displayInventoryMenu() {
        InventoryItem[] inventoryList = InventoryControl.getSortedInventoryList();
        int g = 1;
        
        this.console.println("\n\nInventory List");
        this.console.println("-------------------");
        for (InventoryItem item: inventoryList){
            if (item.getQuantity()>0){
                this.console.println("\n" + g + " - ");
                this.console.print(item + ": " + item.getDescription());
                g++;
            }
        }
    }

    private char resultAction(char charSelection) {
        switch (charSelection){
            case '1':
                this.console.println("\nYou,Fezzik, and Inigo put on the Holocaust Cloak and shoot "
                        + "\nflames all around you. The guards are scare off and you enter the Castle!");
                this.console.println("\nYou have defeated this challenge.");
                Scene.CastleGate.setCompleted(Boolean.TRUE);
                break;
            case '2':
                this.console.println("\nYou have offered water to the guards. They drink it, but still"
                        + "\ndo not let you enter. Try something else.");
                break;
            case '3':
                this.console.println("\nYou used the knife to try to fight off the guards. You manage to"
                        + "\nkill over half of the guards but in the end they overpower and arrest you.");
                DefeatMenuView defeat = new DefeatMenuView();
                defeat.display();
                charSelection = '1';
                break;
            case '4':
                this.console.println("You take the pill miracle max gave you and now you have full health"
                        + "\nrestored! Now what?");
                break;
            case '5':
                this.console.println("You use the rocks and throw them at the guards! The angered guards"
                        + "\narrest you and your friends.");
                DefeatMenuView lose = new DefeatMenuView();
                lose.display();
                charSelection = '1';
                break;
            case '6':
                this.console.println("You use the rope to tie up a few of the guards and manage to subdue"
                        + "\na few more in combat but there are still too many guards. You and your friends"
                        + "\nare arrested.");
                DefeatMenuView end = new DefeatMenuView();
                end.display();
                charSelection = '1';
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Whoops, you need to select one of item 1 through 6.");
                break;
        }
        return charSelection;
    }
    
}
