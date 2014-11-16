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
public enum Item implements Serializable {
    
    goblet,
    rocks,
    rope,
    cloak,
    pill;
    
    
    private String description ;

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
