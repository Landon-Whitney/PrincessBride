/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

/**
 *
 * @author Robbie
 */
public class SceneControl {
    public double percentSolution(int gramsIocane,int gramsWine){
    
        if(gramsIocane < 0 || gramsIocane > 20 ){ //No Iocane or too much
            return -1;
        }
        if(gramsWine < 0 || gramsWine > 1000){//No wine or too much
            return -1;
        }

    double percentSolution = gramsIocane / (gramsIocane + gramsWine) * 100;
    double roundedPercent = Math.round(percentSolution * 100.0)/100.0;
    
    return roundedPercent;
    
    }
    public double computerRhymingWord(int gameScore){


        if(gameScore < 0 || gameScore > 100){ //No score or too high a score
            return -1;
        }
    double gameScores = gameScore;
    double averageScore = gameScores/3;//average the three games
    double percentScore = averageScore * 0.1;//calculate 10 percent
    double computerRhymingWord = averageScore - percentScore;//reduce the average by 10%

    return computerRhymingWord;
    
    }
 
    public double calculateIngredientVolume(int radius, int height){
        if(radius < 0 || radius > 100) {
            return -1;
        }
        if(height < 0 || height > 100) {
            return -1;
        }
        
        double volume = (double)((Math.PI * Math.pow(radius, 2) * height)/1000);
        double roundedVolume = Math.round(volume * 100.0)/100.0;
        return roundedVolume;
    }
    
    public boolean validScene(String scene) {
        return true;
    }
}
