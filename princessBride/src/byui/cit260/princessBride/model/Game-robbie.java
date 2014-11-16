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
public class Game implements Serializable {
    private double totalTime;
    private double completedScenes;
<<<<<<< HEAD
    private Player player;
    private Map map;
    private Inventory[] inventoryList;
=======
    
    private Item[] item;
    private Map map;

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    private Player player;
>>>>>>> origin/master

    public Game() {
    }
    

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getCompletedScenes() {
        return completedScenes;
    }

    public void setCompletedScenes(double completedScenes) {
        this.completedScenes = completedScenes;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player){
        this.player = player;
    }
    
    public Inventory[] getinventoryList(){
        return inventoryList;
    }
    public void setInventory(Inventory[] inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    public Map getMap (){
        return map;
    }
    
    public void setMap (Map map){
        this.map = map;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", completedScenes=" + completedScenes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.completedScenes) ^ (Double.doubleToLongBits(this.completedScenes) >>> 32));
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.completedScenes) != Double.doubleToLongBits(other.completedScenes)) {
            return false;
        }
        return true;
    }  


}
