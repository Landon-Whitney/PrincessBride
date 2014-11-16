/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;

import byui.cit260.princessBride.control.GameControl;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author whitneydavis
 */
public class Map implements Serializable{

    private static Scene[] createScenes() {
        return null;
    }

    private Integer rowCount;
    private Integer columnCount;
    private Location [][] locations;

    public Map() {
    }
    public Map(int noOfRows, int noOfColumns){
        if (noOfRows < 1 || noOfColumns < 1)
            System.out.println("The number of rows and columns must be > zero.");
            return;
    }


    
    private static Map createMap(){
        //create the map for the game
        Map map = new Map (20,20);
        //create the scenes for the game
        Scene[] scenes = createScenes();
        //assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }
    
    public Location [][] getLocations(){
        return locations;
    }
    
    public void setLocations(Location [][] locations){
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.rowCount);
        hash = 73 * hash + Objects.hashCode(this.columnCount);
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
        final Map other = (Map) obj;
        if (!Objects.equals(this.rowCount, other.rowCount)) {
            return false;
        }
        if (!Objects.equals(this.columnCount, other.columnCount)) {
            return false;
        }
        return true;
    }
    
    
}
