/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princessbride;

import byui.cit260.princessBride.model.Game;
import byui.cit260.princessBride.model.Player;
import byui.cit260.princessBride.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author whitneydavis
 */
public class PrincessBride {
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static BufferedReader inFile = null;
    private static PrintWriter outFile = null;
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        PrincessBride.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        PrincessBride.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        PrincessBride.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PrincessBride.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        PrincessBride.player = player;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{ 
            PrincessBride.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            PrincessBride.outFile =
                    new PrintWriter(System.out, true);
            String filePath = "log.txt";
            PrincessBride.logFile = new PrintWriter(filePath);
            
            //create StartProgramView and start the program
            StartProgramView startProgramView = new StartProgramView();
            try{
                startProgramView.display();
            }catch (Throwable te){
                System.out.println(te.getMessage());
                te.printStackTrace();
                startProgramView.display();
        }
        
        }catch (Exception e){
                System.out.println("Exception: " + e.toString()+
                                   "\nCause: " + e.getCause()+
                                   "\nMessage: " + e.getMessage());
        }
        finally{
            try {
                PrincessBride.inFile.close();
                PrincessBride.outFile.close();
                PrincessBride.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
            PrincessBride.outFile.close();
           
        }
        
    }
    
}
