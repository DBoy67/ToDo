package models;

public class ToDo {

    private String task;
    private boolean status;

    public ToDo() {
    }

    public ToDo(String task) {
        this.task = task;
        this.status = false;
    }

    public String getTask() {
        return task;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;

    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {

        return task;
    }

}
