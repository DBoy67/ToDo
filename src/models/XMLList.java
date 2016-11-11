/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony Eriksson <Tony.Eriksson>
 */
public class XMLList {
    
   private List<ToDo> myToDoList = new ArrayList<ToDo>();

    public List<ToDo> getMyToDoList() {
	return myToDoList;
    }

    public void setMyToDoList(List<ToDo> myToDoList) {
	this.myToDoList = myToDoList;
    }
    
}
