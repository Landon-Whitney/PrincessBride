/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

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
        this.console.println("");
    }
    
}
