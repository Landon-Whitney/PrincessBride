/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.model;
import byui.cit260.princessBride.view.InigosGrottoView;
import byui.cit260.princessBride.view.View;
import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author whitneydavis
 */
public enum Scene implements Serializable{
    InigosGrotto("A wild wind-swept precipce. Just the right place for a rhyming game.", "IGR"),
    FezzicksChallenge("A rocky plain.", "FCh"),
    VizzinisPoisonPuzzle("A pleasant picnic with poison on the side.", "VPP"),
    Fireswamp("A wild forest full of traps for the unwary.", "FSW"),
    PitOfDespair("Prince Humperdink's secret lab.", "POD"),
    MiracleMax("A modest cottage covered by ivy.", "MMX"),
    CastleGate("An imposing gate with but one key and double the guards.", "CGT"),
    CastleMaze("Stone walls with narrow passageways go off in every direction.  Which way do you go?", "CMZ"),
    TrueLovesKiss("A ride into the sunset with a beautiful princess.", "TLK");
    
    private final String description;
    private final String shortDescription;
    private final Point coordinates;
    private Boolean blocked;
    private Boolean completed;
    private Location location;

    Scene(String description, String shortDesc) {
        this.description = description;
        this.shortDescription = shortDesc;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
 
    public Location getLocation (){
        return location;
    }
    public void setLocation (Location location){
        this.location = location;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", blocked=" + blocked + ", shortDescription=" + shortDescription + '}';
    }
}

