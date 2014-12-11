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
    InigosGrotto("a wild wind-swept precipce. Just the right place for a rhyming game.", "IGR", "Inigos Grotto"),
    FezzicksChallenge("a rocky plain.", "FCh", "Fezziks Challenge"),
    VizzinisPoisonPuzzle("a pleasant picnic with poison on the side.", "VPP","Vizzinis Poison Puzzle" ),
    Fireswamp("a wild forest full of traps for the unwary.", "FSW", "Fireswamp"),
    PitOfDespair("Prince Humperdink's secret lab.", "POD", "Pit of Despair"),
    MiracleMax("a modest cottage covered by ivy.", "MMX", "Miracle Max"),
    CastleGate("an imposing gate with but one key and double the guards.", "CGT", "Castle Gate"),
    CastleMaze("stone walls with narrow passageways go off in every direction.  Which way do you go?", "CMZ", "Castle Maze"),
    TrueLovesKiss("a ride into the sunset with a beautiful princess.", "TLK", "True Love\'s Kiss");
    
    private final String description;
    private final String shortDescription;
    private final String name;
    private boolean blocked;
    private boolean completed;
    private Location location;

    Scene(String description, String shortDesc, String name) {
        this.description = description;
        this.shortDescription = shortDesc;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

