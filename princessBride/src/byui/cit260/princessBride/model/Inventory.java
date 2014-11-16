/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import java.io.Serializable;

/**
 *
 * @author Robbie
 */
public class Inventory implements Serializable {
    private double quantity;

    public static Inventory[] createInventoryList() {
        
        Inventory [] inventory = new Inventory[4];
        
        Inventory goblet = new Inventory();
        goblet.setDescription("goblet of water");
        goblet.setQuantity(0);
        goblet.setRequiredAmount(1);
        inventory[Item.goblet.ordinal()] = goblet;
        
        Inventory rocks = new Inventory();
        rocks.setDescription("bag of rocks");
        rocks.setQuantity(0);
        rocks.setRequiredAmount(1);
        inventory[Item.rocks.ordinal()] = rocks;
        
        Inventory rope = new Inventory();
        rope.setDescription("coil of rope");
        rope.setQuantity(0);
        rope.setRequiredAmount(1);
        inventory[Item.rope.ordinal()] = rope;
        
        Inventory cloak = new Inventory();
        cloak.setDescription("holocaust cloak made of fireproof material");
        cloak.setQuantity(0);
        cloak.setRequiredAmount(1);
        inventory[Item.cloak.ordinal()] = cloak;
        
        Inventory pill = new Inventory();
        pill.setDescription("a miracle pill that brings the motly dead back to life");
        pill.setQuantity(0);
        pill.setRequiredAmount(1);
        inventory[Item.pill.ordinal()] = pill;
        
        return inventory;
        
    }
      

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" + "quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.quantity) ^ (Double.doubleToLongBits(this.quantity) >>> 32));
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
        final Inventory other = (Inventory) obj;
        if (Double.doubleToLongBits(this.quantity) != Double.doubleToLongBits(other.quantity)) {
            return false;
        }
        return true;
    }

    private void setDescription(String description) {
        
    }

    private void setRequiredAmount(int i) {
        
    }
    
    
    
}
