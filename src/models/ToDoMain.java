package models;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToDoMain {

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
		Logger.getLogger(ToDoMain.class.getName()).log(Level.SEVERE, null, ex1);
	    }
	}

	while (whatToDo != 8) {
	    System.out.println("Welcome. What do you want to do?");

	    System.out.println("1. Add a task.");
	    System.out.println("2. Remove a task.");
	    System.out.println("3. Search for a task.");
	    System.out.println("4. Edit a task.");
	    System.out.println("5. Change status for task.");
	    System.out.println("6. Remove all done tasks.");
	    System.out.println("7. List all tasks");
	    System.out.println("8. Exit");

	    try {

		whatToDo = Integer.parseInt(in.nextLine());

		switch (whatToDo) {
		    case 1:
			String toDo;
			System.out.print("Enter task: ");
			toDo = in.nextLine();
			ToDo task = new ToDo(toDo);
			myToDoList.addTask(task);
			System.out.println("Added the following task: " + task.getTask());
			System.out.println(" ");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 2:
			int toRemove;
			System.out.println("These are all the available tasks:");
			myToDoList.printAllTasks();
			System.out.print("Enter no of the task you want to remove: ");
			toRemove = Integer.parseInt(in.nextLine());
			System.out.println("Removed the following task: " + myToDoList.getMyToDoList().get(toRemove).getTask());
			myToDoList.removeTask(toRemove);
			System.out.println(" ");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 3:
			String toSearch;
			System.out.print("What task are you looking for: ");
			toSearch = in.nextLine();
			 {
			    try {
				System.out.println(myToDoList.searchForTask(toSearch));
			    } catch (TaskNotFoundException ex) {
				System.out.println("Sorry. No such task.");
			    }
			}
			System.out.println(" ");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 4:
			int toEdit;
			String newTaskName;
			myToDoList.printAllTasks();
			System.out.print("Enter no of the task you want to rename: ");
			toEdit = Integer.parseInt(in.nextLine());
			System.out.print("Enter new name of the task: ");
			newTaskName = in.nextLine();
			myToDoList.editTask(toEdit, newTaskName);
			System.out.println(" ");
			System.out.println("Task renamed");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 5:
			int toChange;
			System.out.println("These are all the available tasks:");
			myToDoList.printAllTasks();
			System.out.print("Enter no of the task you want to change status on: ");
			toChange = Integer.parseInt(in.nextLine());
			myToDoList.changeStatus(toChange);
			System.out.println("Status changed.");
			System.out.println(" ");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 6:
			myToDoList.removeAllDoneTasks();
			System.out.println("All tasks marked as done have been removed");
			System.out.println(" ");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 7:
			myToDoList.printAllTasks();
			System.out.println(" ");
			System.out.println("Press Enter to continue");
			in.nextLine();
			System.out.println(" ");
			break;
		    case 8:
			System.out.println("Ending program");
			 {
			    try {
				myToDoList.writeToFile();
				in.close();
			    } catch (IOException ex) {
				Logger.getLogger(ToDoMain.class.getName()).log(Level.SEVERE, null, ex);
			    }
			}
			break;
		    default:
			System.out.println(" ");
			break;
		}
	    } catch (NumberFormatException nfe) {
		System.out.println("Wrong input. Please choose a number from the menu.");
		System.out.println(" ");
	    }
	}

    }
}
