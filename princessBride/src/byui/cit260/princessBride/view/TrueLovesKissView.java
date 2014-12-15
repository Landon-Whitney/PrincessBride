/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

import byui.cit260.princessBride.model.Player;
import princessbride.PrincessBride;

/**
 *
 * @author Roberta
 */
public class TrueLovesKissView extends View {
    
    public TrueLovesKissView(){
    
            super("\n\n****************************************************"
                    +"\n               True Loves Kiss                   "
                    +"\n Dread Pirate "+PrincessBride.getPlayer()+" you have  "
                    +"\n saved Princess Buttercup!                            "
                    +"\n You now have a chance to kiss her.                   "
                    +"\n*****************************************************"
                    +"\nDo you want to kiss Princess Buttercup? Enter Y or N   " );
            
    
    }

    @Override
    public void doAction(char value) {
       switch (Character.toUpperCase(value)){
           case 'Y':
               this.console.println("\n---------------------------------------------------"
                                    +"\nSince the invention of the kiss, there have" 
                                    +"\nbeen five kisses that were rated the most" 
                                    +"\npassionate, the most pure. This one left them all" 
                                    +"\n behind.  The End."
                                    +"\n---------------------------------------------------");
               break;
               
           case 'N':
               this.console.println( "\n----------------------------------------------------"
                                    +"\nYeah, I guess that might be weird.  "
                                    +"\nThe princess thanks you profusely and"
                                    +"\nYou part ways with a hardy handshake.  The End."
                                    +"\n-----------------------------------------------------");
               break;
      
           default:
               ErrorView.display(this.getClass().getName(), "Please enter Y or N.");
       
       }
    }
              
}
