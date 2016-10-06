/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ivamat907
 */
public class GameGroupManager {
    public HashMap<String, ArrayList> groups = new HashMap<>();
    public void addToGroup(String group,GameObject obj){
        checkGroup(group);
        this.groups.get(group).add(obj);
    }
    public ArrayList getGroup(String group){
        checkGroup(group);
        return (ArrayList) this.groups.get(group).clone();
    }
    public void removeFromGroup(String group,GameObject obj){
        checkGroup(group);
        this.groups.get(group).remove(obj);
    }
    public void clearGroup(String group){
        checkGroup(group);
        this.groups.get(group).clear();
    }
    
    public boolean checkGroup(String group){
        if(this.groups.containsKey(group)){
            return true;
        }else{
            this.groups.put(group, new ArrayList<GameObject>());
            return false;
        }
        
    }
    
}
