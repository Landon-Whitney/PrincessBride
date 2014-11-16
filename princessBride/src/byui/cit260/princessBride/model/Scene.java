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
 * @author whitneydavis
 */
public enum Scene implements Serializable{
    InigosGrotto("A wild wind-swept precipce. Just the right place for a rhyming game."),
    FezzicksChallenge("A rocky plain."),
    VizzinisPoisonPuzzle("A pleasant picnic with poison on the side."),
    Fireswamp("A wild forest full of traps for the unwary."),
    PitOfDespair("Prince Humperdink's secret lab."),
    MiracleMax("A modest cottage covered by ivy."),
    CastleGate("An imposing gate with but one key and double the guards."),
    CastleMaze("Stone walls with narrow passageways go off in every direction.  Which way do you go?");
    
    private final String description;
    private final Point coordinates;
    private Boolean blocked;
    private Boolean status;
    private Item[] item;
    private Location location;

    Scene(String description) {
        this.description = description;
        coordinates = new Point(1,1);
    }

    public String getDescription() {
        return description;
    }
    
        public Point getCoordinates() {
        return coordinates;
        }

    

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public Item[] getItem (){
        return item;
    }
    
    public Location getLocation (){
        return location;
    }
    public void setLocation (Location location){
        this.location = location;
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", blocked=" + blocked + ", status=" + status + '}';
    }
}

