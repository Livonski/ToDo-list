package src.java.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public List<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<Task>();
    }

    public void addTask(String name, String description){
        Task newTask = new Task(tasks.size() + 1, name, description);
        tasks.add(newTask);

        //Tmp method for outputing current tasks
        printTasks();
    }

    public Task getTask(int ID){
        for (Task task : tasks) {
            if (task.getID() == ID)
                return task;
        }
        //TODO: propper error handling
        return null;
    }

    public void printTasks()
    {
        for (Task task : tasks) {
            System.out.println("Task ID: " + task.getID());
            System.out.println("Task Name: " + task.getName());
            System.out.println("Task Description: " + task.getDescription());
            System.out.println("|============================================|");
        }
    }
}
