/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robbie
 */
public class SceneControlTest {
    
    public SceneControlTest() {
    }

    /**
     * Test of percentSolution method, of class SceneControl.
     */
    @Test
    public void testPercentSolution() {
        System.out.println("\tTest case #1 PercentSolution");
        double gramsIocane = 6.0;
        double gramsWine = 500.0;
        SceneControl instance = new SceneControl();
        double expResult = 1.19;
        double result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);

       
     System.out.println("\tTest Case #2");
        gramsIocane = -1.0;
        gramsWine = 500.0;
        
        expResult = -1.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);
        
    System.out.println("\tTest Case #3");
        gramsIocane = 21.0;
        gramsWine = 500.0;
        
        expResult = -1.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);
        
    System.out.println("\tTest Case #4");
        gramsIocane = 6.0;
        gramsWine = -1.0;
        
        expResult = -1;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);
        
    System.out.println("\tTest Case #5");
        gramsIocane = 6.0;
        gramsWine = 1001.0;
        
        expResult = -1.00;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);
        
     System.out.println("\tTest Case #6");
        gramsIocane = 0.0;
        gramsWine = 500.0;
        
        expResult = 0.00;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01); 
        
     System.out.println("\tTest Case #7");
        gramsIocane = 20.0;
        gramsWine = 500.0;
        
        expResult = 3.85;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01); 
        
     System.out.println("\tTest Case #8");
        gramsIocane = 6.0;
        gramsWine = 0.0;
        
        expResult = 100.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);
        
     System.out.println("\tTest Case #9");
        gramsIocane = 6.0;
        gramsWine = 1000.0;
        
        expResult = 0.60;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.01);        
    }

    /**
     * Test of calculateIngredientVolume method, of class SceneControl.
     */
    @Test
    public void testCalculateIngredientVolume() {
        System.out.println("calculateIngredientVolume");
        
        System.out.println("\tTest case #1");
        double radius = 1.0;
        double height = 2.0;
        SceneControl instance = new SceneControl();
        double expResult = 0.00628;
        double result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.00001);
        
        
        System.out.println("\tTest case #2");
        radius = -1.0;
        height = 2.0;
        expResult = -1.0;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #3");
        radius = 11.0;
        height = 2.0;
        expResult = -1.0;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #4");
        radius = 1.0;
        height = -1.0;
        expResult = -1.0;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #5");
        radius = 1.0;
        height = 11.0;
        expResult = -1.0;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #6");
        radius = 0.0;
        height = 2.0;
        expResult = 0.0;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #7");
        radius = 10.0;
        height = 2.0;
        expResult = 0.6283;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #8");
        radius = 1.0;
        height = 0.0;
        expResult = 0.0;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("\tTest case #9");
        radius = 1.0;
        height = 10.0;
        expResult = 0.0314;
        result = instance.calculateIngredientVolume(radius, height);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of computerRhymingWord method, of class SceneControl.
     */
    @Test
    public void computerRhymingWord() {
        System.out.println("\tTest case #1FinalScore");
        double gameScore = 41.0;
        SceneControl instance = new SceneControl();
        double expResult = 12.299999999999999;
        double result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #2");
        gameScore = -18.0;
        
        expResult = -1.0;
        result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
         System.out.println("\tTest case #3");
        gameScore = 118.0;
        
        expResult = -1.0;
        result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
         System.out.println("\tTest case #4");
        gameScore = 3.0;
        
        expResult = 0.9;
        result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
         System.out.println("\tTest case #5");
        gameScore = 100;
        
        expResult = 30.0;
        result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("\tTest case #6");
        gameScore = 19.0;
        
        expResult = 5.699999999999999;
        result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
         System.out.println("\tTest case #7");
        gameScore = 1.0;
        
        expResult = 0.3;
        result = instance.computerRhymingWord((int) gameScore);
        assertEquals(expResult, result, 0.0);
        
        
    }
    
}

    
