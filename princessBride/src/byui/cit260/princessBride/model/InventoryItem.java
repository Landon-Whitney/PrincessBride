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
public class InventoryItem implements Serializable {
    private double quantity;
    private String description;
    
    
    private void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
    
    private void setRequiredAmount(int i) {
        
    }
    
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public static InventoryItem[] createInventoryList() {
        
        InventoryItem [] inventory = new InventoryItem[5];
        
        InventoryItem goblet = new InventoryItem();
        goblet.setDescription("goblet of water");
        goblet.setQuantity(0);
        goblet.setRequiredAmount(1);
        inventory[Item.goblet.ordinal()] = goblet;
        
        InventoryItem rocks = new InventoryItem();
        rocks.setDescription("bag of rocks");
        rocks.setQuantity(0);
        rocks.setRequiredAmount(1);
        inventory[Item.rocks.ordinal()] = rocks;
        
        InventoryItem rope = new InventoryItem();
        rope.setDescription("coil of rope");
        rope.setQuantity(0);
        rope.setRequiredAmount(1);
        inventory[Item.rope.ordinal()] = rope;
        
        InventoryItem cloak = new InventoryItem();
        cloak.setDescription("holocaust cloak made of fireproof material");
        cloak.setQuantity(0);
        cloak.setRequiredAmount(1);
        inventory[Item.cloak.ordinal()] = cloak;
        
        InventoryItem pill = new InventoryItem();
        pill.setDescription("a miracle pill that brings the mostly dead back to life");
        pill.setQuantity(0);
        pill.setRequiredAmount(1);
        inventory[Item.pill.ordinal()] = pill;
        
        return inventory;
        
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
        final InventoryItem other = (InventoryItem) obj;
        if (Double.doubleToLongBits(this.quantity) != Double.doubleToLongBits(other.quantity)) {
            return false;
        }
        return true;
    }
     
}
