/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.util.HashMap;

/**
 *
 * @author Axel
 */
public class GameVariables {
    private HashMap<String, Object> variables;
    
    public GameVariables() {
        this.variables = new HashMap<>();
    }
    
    public void put(String key, Object o) {
        this.variables.put(key, o);
    }
    
    public Object get(String key) {
        return this.variables.get(key);
    }
}
