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
    public double percentSolution(double gramsIocane,double gramsWine){
    
        if(gramsIocane < 0 || gramsIocane > 20 ){ //No Iocane or too much
            return -1;
        }
        if(gramsWine < 0 || gramsWine > 1000){//No wine or too much
	return -1;
        }

    double percentSolution = gramsIocane / (gramsIocane + gramsWine) * 100;

    return percentSolution;
    
        
    }
          
}
