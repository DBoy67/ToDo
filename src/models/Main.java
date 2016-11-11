package models;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Main {

    public static ToDoCatalog myToDoList = new ToDoCatalog();

    public static void main(String[] args) {
	int whatToDo = 0;
	Scanner in = new Scanner(System.in);

	try {
	    myToDoList.readFile();
	} catch (IOException ex) {
	    System.out.println("Can't find a startfile. Creating a new one.");
	    System.out.println(" ");

	    try {
		myToDoList.createNewXML();
		myToDoList.readFile();
	    } catch (IOException ex1) {
		Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
	    }
	}
	
	
//            TaskFrame frame = new TaskFrame();
//            frame.setVisible(true);
        


    }
}
