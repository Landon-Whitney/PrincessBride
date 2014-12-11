/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robbie
 */
public enum Actor implements Serializable{
    Vizzini("The mastermind","Vizzini"),
    Fezzick("The muscle","Fezzick"),
    Inigo("The swordsman","Inigo"),
    Miracle_Max("The healer","Miracle Max"),
    Prince_Humperdink("The evil villian","Prince Humperdink"),
    Princess_Buttercup("The long-lost love","Princess Buttercup");
    
    private final String name;
    private final String description;

    Actor(String description, String name) {
        this.name = name;
        this.description = description;
    }
   
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "name = " + name + ", description = " + description;
    }

    
   
    
}
