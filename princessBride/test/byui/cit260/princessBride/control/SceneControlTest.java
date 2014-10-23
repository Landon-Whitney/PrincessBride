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
        System.out.println("percentSolution");
        double gramsIocane = 6.0;
        double gramsWine = 500.0;
        SceneControl instance = new SceneControl();
        double expResult = 1.185770750988142;
        double result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);

       
     System.out.println("\tTest Case #2");
        gramsIocane = -1.0;
        gramsWine = 500.0;
        
        expResult = -1.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);
        
    System.out.println("\tTest Case #3");
        gramsIocane = 21.0;
        gramsWine = 500.0;
        
        expResult = -1.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);
        
    System.out.println("\tTest Case #4");
        gramsIocane = 6;
        gramsWine = -1;
        
        expResult = -1.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);
        
    System.out.println("\tTest Case #5");
        gramsIocane = 6;
        gramsWine = 1001;
        
        expResult = -1.0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);
        
     System.out.println("\tTest Case #6");
        gramsIocane = 0;
        gramsWine = 500;
        
        expResult = 0;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0); 
        
     System.out.println("\tTest Case #7");
        gramsIocane = 20;
        gramsWine = 500;
        
        expResult = 3.8461538461538463;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0); 
        
     System.out.println("\tTest Case #8");
        gramsIocane = 6;
        gramsWine = 0;
        
        expResult = 100;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);
        
     System.out.println("\tTest Case #9");
        gramsIocane = 6;
        gramsWine = 1000;
        
        expResult = 0.5964214711729622;
        
        result = instance.percentSolution(gramsIocane, gramsWine);
        assertEquals(expResult, result, 0.0);        
    }
    
}

    