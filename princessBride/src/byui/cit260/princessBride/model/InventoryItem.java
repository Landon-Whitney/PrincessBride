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
    private String name;
    private double quantity;
    private String description;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
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
        
        InventoryItem [] inventory = new InventoryItem[6];
        
        InventoryItem goblet = new InventoryItem();
        goblet.setName("Goblet");
        goblet.setDescription("goblet of water");
        goblet.setQuantity(0);
        goblet.setRequiredAmount(1);
        inventory[Item.goblet.ordinal()] = goblet;
        
        InventoryItem rocks = new InventoryItem();
        rocks.setName("Rocks");
        rocks.setDescription("bag of rocks");
        rocks.setQuantity(0);
        rocks.setRequiredAmount(1);
        inventory[Item.rocks.ordinal()] = rocks;
        
        InventoryItem rope = new InventoryItem();
        rope.setName("Rope");
        rope.setDescription("coil of rope");
        rope.setQuantity(0);
        rope.setRequiredAmount(1);
        inventory[Item.rope.ordinal()] = rope;
        
        InventoryItem knife = new InventoryItem();
        knife.setName("Knife");
        knife.setDescription("gilded dagger");
        knife.setQuantity(0);
        knife.setRequiredAmount(1);
        inventory[Item.knife.ordinal()] = knife;
        
        InventoryItem cloak = new InventoryItem();
        cloak.setName("Cloak");
        cloak.setDescription("flame retardant holocaust cloak");
        cloak.setQuantity(0);
        cloak.setRequiredAmount(1);
        inventory[Item.cloak.ordinal()] = cloak;
        
        InventoryItem pill = new InventoryItem();
        pill.setName("Pill");
        pill.setDescription("miracle pill that restores life to the mostly dead");
        pill.setQuantity(0);
        pill.setRequiredAmount(1);
        inventory[Item.pill.ordinal()] = pill;
        
        return inventory;
        
    }
    
    @Override
    public String toString() {
        return name;
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
