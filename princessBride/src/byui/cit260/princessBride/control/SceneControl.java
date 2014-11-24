/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    public int checkPlayerRhymingWord(){
        
        String pest[] = {"best","blessed","blest","breast","chest","crest","dressed","geste","guessed","guest","jest","lest","messed","nest","pressed","quest","rest","stressed","test","vest","west","wrest","zest"};
        String eel[] = {"creel","deal","feel","he'll","heal","heel","keel","kneel","meal","peal","peel","real","reel","seal","she'll","speel","spiel","squeal","steal","steel","teal","veal","wheel","zeal"};
        String wed[] = {"bed","bled","bread","bred","dead","dread","fed","fled","fred","head","lead","led","ped","pled","read","red","redd","said","shed","shred","sled","sped","spread","stead","thread","tread","zed"};
    
        List<String> pestGuess = new ArrayList<>();//to create an array that keeps track of the player's correct guesses
        List<String> eelGuess = new ArrayList<>();
        List<String> wedGuess = new ArrayList<>();
        
        int wordCountPest = pest.length;//to tell the player how many rhyming words are available
        int wordCountEel = eel.length;
        int wordCountWed = wed.length;
        int playerScore = 0;
        boolean wrongAnswer = false;
        boolean valid = false;//no input has put in by the player
        Scanner keyboard = new Scanner(System.in);
    
    while (!valid && !wrongAnswer){
        
        System.out.println("Find a one sylable word that rhymes with pest");
        System.out.println("I know "+wordCountPest+" words that rhyme");
        String playersRhyme = keyboard.nextLine();
        playersRhyme = playersRhyme.trim();
        
        if (playersRhyme.length()< 1){//player hits enter with no word
            System.out.println("You stumped already?  I will defeat you! Lets try another word.");
            wrongAnswer = true;
            
           }
        for(String word : pest){
            if(playersRhyme.matches(word) && !pestGuess.contains(playersRhyme)){
               pestGuess.add(playersRhyme);//adds players input to array to check against rhyme array
               playerScore++;
               System.out.println("You have "+playerScore+" rhymed words");
               if(pestGuess.size() == pest.length){
               System.out.println("You got all of the same words as I did! Where did you get your training?!");
               wrongAnswer = true;
               }
            }
                 
          }
       }
        wrongAnswer = false;
       while (!valid && !wrongAnswer){
        
        System.out.println("Find a one sylable word that rhymes with eel");
        System.out.println("I know "+wordCountEel+" words that rhyme");
        String playersRhyme = keyboard.nextLine();
        playersRhyme = playersRhyme.trim();
        
        if (playersRhyme.length()< 1){//player hits enter with no word
            System.out.println("You stumped already?  I will defeat you! Let's try another word.");
                wrongAnswer = true;
            
           }
        for(String word : eel){
            if(playersRhyme.matches(word)&& !eelGuess.contains(playersRhyme)){
               eelGuess.add(playersRhyme); 
            playerScore++;
            System.out.println("You have "+playerScore+" rhymed words");
             if(eelGuess.size() == eel.length){
               System.out.println("You got all of the same words as I did! Where did you get your training?!");
               wrongAnswer = true;
             }
            }
              
          }
       } 
       wrongAnswer = false;
       while (!valid && !wrongAnswer){
        
        System.out.println("How about one about a wedding?  Find one syllable words that rhyme with wed");
        System.out.println("I know "+wordCountWed+" words that rhyme");
        String playersRhyme = keyboard.nextLine();
        playersRhyme = playersRhyme.trim();
        
        if (playersRhyme.length()< 1){//player hits enter with no word
            System.out.println("You stumped already?  I will defeat you!");
                wrongAnswer = true;
            
           }
        for(String word : wed){
            if(playersRhyme.matches(word)&& !wedGuess.contains(playersRhyme)){
               wedGuess.add(playersRhyme); 
            playerScore++;
            System.out.println("You have "+playerScore+" rhymed words");
             if(wedGuess.size() == wed.length){
               System.out.println("You got all of the same words as I did! Where did you get your training?!");
               wrongAnswer = true;
            }
            }
          }
       }
        

        return playerScore;
    
    }
        public double computerRhymingWord(int gameScore){


        if(gameScore < 0 || gameScore > 100){ //No score or too high a score
            return -1;
        }
    double gameScores = gameScore;
    double averageScore = gameScores/3;//average the three games
    double percentScore = averageScore * 0.1;//calculate 10 percent
    double rhymingWordScore = averageScore - percentScore;//reduce the average by 10%

    return rhymingWordScore;
    
    }

    public int[] createScoreArray(int[] array, int i) {
        int randomSelection = (int)(Math.random()*2);
        array[i] = randomSelection;
        return array;
    }

    public int winOrLose(int[] score) {
        int arraySum = 0;
        
        for(int i = 0; i < score.length; i++) {
            arraySum += score[i];
        }
        return arraySum;
    }
}
