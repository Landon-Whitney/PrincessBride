/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.exceptions;

/**
 *
 * @author Roberta
 */
public class SceneControlException extends Exception {
    
    public SceneControlException(){
    
    }

    public SceneControlException(String message) {
        super(message);
    }

    public SceneControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public SceneControlException(Throwable cause) {
        super(cause);
    }

    public SceneControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
