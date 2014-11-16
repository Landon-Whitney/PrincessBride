/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robbie
 */
<<<<<<< HEAD
public enum Item implements Serializable {
    
    goblet,
    rocks,
    rope,
    cloak,
    pill;
    
    
    private String description ;
=======
public class Item implements Serializable {
    private String description ;

    private Game[] game;
    private Scene[] scene;

    public Item() {
        
    }
    
    public Game[] getGame() {
        return game;
    }

    public void setGame(Game[] game) {
        this.game = game;
    }
>>>>>>> origin/master

    public Scene[] getScene() {
        return scene;
    }

    public void setScene(Scene[] scene) {
        this.scene = scene;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Items{" + "description=" + description + '}';
    }


    
    
}
