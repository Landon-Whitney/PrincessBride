/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.view;

/**
 *
 * @author Robbie
 */
public class FireswampView extends View {
    
    public FireswampView(){
    
            super("\n"
                + "\n-----------------------------------------------"
                + "\n You are so happy to be reunited with Buttercup"
                + "\n But danger approaches!  The evil Prince       "
                + "\n Humperdink has followed you!  You roll down   "
                + "\n a hill and run into the fireswamp to seek     "
                + "\n safety.  But there are many dangers in the    "
                + "\n fireswamp.  Many have entered, none have      "
                + "\n come out....Be very careful in there.         "
                + "\n-------------------------------------------------"
            
                +"\n You hear a noise in the darkened woods!        "
                +"\n Part of being careful is choosing the right    "
                +"\n weapon.  You have gathered a few things.       "
                +"\n What will you choose?                          "
                +"\n G - the goblet you got from Vizini             "
                +"\n B - the bag of rocks from Fezzik               "
                +"\n R - the rope from Inigo                        ");
            
                
    }       
    public void doAction(char selection){
        switch (selection){
            case 'G':
                this.inventory();
                break;
            case 'B':
                this.inventory();
                break;
            case 'R':
                this.inventory();
                break;
            default:
                this.console.println("\n Please choose a G - for a goblet,"
                                   +"\n a B - for a bag of rocks, or    "
                                   +"\n a R - for a rope.");
           
        }
    
    }        

    private void inventory(){
                this.console.println("inventory fuction called");
        
        
        
    }

    
    
    }
    

