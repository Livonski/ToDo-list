package src.java.tasks;

import java.io.DataInputStream;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import src.java.saves.ILoadable;
import src.java.saves.ISavable;

public class TaskManager implements ISavable, ILoadable {
    private List<Task> tasks;
    private int maxID;

    public TaskManager(){
        tasks = new ArrayList<Task>();
        maxID = 0;
    }

    public byte[] save(){
        ByteArrayOutputStream bAStream = new ByteArrayOutputStream();
        bAStream.write(tasks.size());
        //bAStream.writr
        for(Task task : tasks){
            bAStream.writeBytes(task.save());
        }
        return bAStream.toByteArray();
    }

    public void load(DataInputStream data){
        tasks = new ArrayList<Task>();
        maxID = Integer.MIN_VALUE;
        try(data){
            System.out.println(data.available());
            int numTasks = data.readByte();
            for (int i = 0; i < numTasks; i++){
                int ID = data.readByte();
                String name = data.readUTF();
                
                /*int nameLength = data.readInt();
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < nameLength - 1; j++){
                    System.out.print(j);
                    sb.append((char)data.readByte());
                }
                String name = sb.toString();*/

                String description = data.readUTF();
                addTask(ID, name, description);
                maxID = Math.max(maxID, ID);
            }
        }
        catch(Exception excuse){
            excuse.printStackTrace();
        }
    }

    public void addTask(int ID, String name, String description){
        Task newTask = new Task(ID, name, description);
        tasks.add(newTask);

        //Tmp method for outputing current tasks
        printTasks();
    }

    public void addTask(String name, String description){
        Task newTask = new Task(maxID, name, description);
        maxID++;
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
