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
    Vizzini("The mastermind"),
    Fezzick("The muscle"),
    Inigo("The swordsman"),
    Miracle_Max("The healer"),
    Prince_Humperdink("The evil villian"),
    Princess_Buttercup("The long-lost love");
    
    private final String description;
    private final Point coordinates;
    
    private InventoryItem[] inventory;
    private Game[] game;

    Actor(String description) {
        this.description = description;
        coordinates = new Point(1,1);
    }
   

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Actor{" + "description=" + description + ", coordinates=" + coordinates + ", inventory=" + inventory + ", game=" + game + '}';
    }

    
   
    
}
