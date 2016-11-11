package models;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ToDoCatalog {

    String toDoList = "myList.xml";

    XMLList xml;

    public void readFile() throws IOException {
        xml = XmlIO.loadObject(toDoList, XMLList.class);
    }

    // Adds a new task
    public void addTask(ToDo toDo) {
        xml.getMyToDoList().add(toDo);
    }

    // Removes a task. Index number from user
    public void removeTask(int index) {
        xml.getMyToDoList().remove(index);
    }

    public List<ToDo> getMyToDoList() {
        return xml.getMyToDoList();
    }

    public int getNumberofTasks() {
        return xml.getMyToDoList().size();
    }

    // Prints All tasks in list
    public void printAllTasks() {
        if (xml.getMyToDoList().isEmpty()) {
            System.out.println("There are no tasks in the list.");
        } else {
            boolean didIt;
            String taskStatus;
            System.out.println("Listing all of your tasks:");
            Iterator<ToDo> toDoIt = xml.getMyToDoList().iterator();
            while (toDoIt.hasNext()) {

                ToDo t = toDoIt.next();
                didIt = t.getStatus();

                if (didIt == false) {
                    taskStatus = " ";
                } else {
                    taskStatus = "X";
                }
                System.out.println(xml.getMyToDoList().indexOf(t) + " " + "[" + taskStatus + "]" + " " + t.getTask());
            }
        }
    }

    // Switches status from true to false and vice versa.
    public void changeStatus(int index) {
        if (xml.getMyToDoList().get(index).getStatus() == false) {
            xml.getMyToDoList().get(index).setStatus(true);
        } else {
            xml.getMyToDoList().get(index).setStatus(false);
        }

    }

    // Clears the list completely
    public void removeAllTasks() {
        xml.getMyToDoList().clear();
    }

    // Finds all tasks where status is true and removes them.
    public void removeAllDoneTasks() {
        int i;
        for (i = 0; i < xml.getMyToDoList().size(); i++) {
            if (xml.getMyToDoList().get(i).getStatus() == true) {
                xml.getMyToDoList().remove(i);
            }
        }

    }

    // Takes an index number and a string from the user and changes the name of
    // the task on that index.
    public void editTask(int id, String newTask) {
        xml.getMyToDoList().get(id).setTask(newTask);
    }

    // Searches for a task from a user input (string) and returns a text string
    // with index, status and task name
    // or throws an exception if the task is not found at all.
    public String searchForTask(String whatTask) throws TaskNotFoundException {
        String task;
        boolean didIt;
        String taskStatus;
        int index;
        for (int i = 0; i < xml.getMyToDoList().size(); i++) {
            if (xml.getMyToDoList().get(i).getTask().equals(whatTask)) {
                task = xml.getMyToDoList().get(i).getTask();
                didIt = xml.getMyToDoList().get(i).getStatus();
                index = xml.getMyToDoList().indexOf(xml.getMyToDoList().get(i));
                if (didIt == false) {
                    taskStatus = " ";
                } else {
                    taskStatus = "X";
                }
                String foundTask = index + " " + "[" + taskStatus + "]" + " " + task;
                return foundTask;
            }
        }
        throw new TaskNotFoundException();
    }

    public void writeToFile() throws IOException {
        //for (int i = 0; i < myToDoList.size(); i++) {
        XmlIO.saveObject(toDoList, xml);
        //}
    }

    public void createNewXML() throws IOException {
        XMLList xmlNew = new XMLList();
        XmlIO.saveObject(toDoList, xmlNew);
    }
}
