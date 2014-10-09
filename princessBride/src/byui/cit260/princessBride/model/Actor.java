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
public class Actor implements Serializable{
   private String name;
   private Boolean defeated;

    public Actor() {
    }
   
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefeated() {
        return defeated;
    }

    public void setDefeated(Boolean defeated) {
        this.defeated = defeated;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", defeated=" + defeated + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.defeated);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.defeated, other.defeated)) {
            return false;
        }
        return true;
    }
   
    
}
