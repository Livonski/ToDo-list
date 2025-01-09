package src.main.java.tasks;

import java.io.DataInputStream;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import src.main.java.saves.ILoadable;
import src.main.java.saves.ISavable;

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
        for(Task task : tasks){
            bAStream.writeBytes(task.save());
        }
        return bAStream.toByteArray();
    }

    public void load(DataInputStream data){
        tasks = new ArrayList<Task>();
        maxID = Integer.MIN_VALUE;
        try(data){
            int numTasks = data.readByte();
            for (int i = 0; i < numTasks; i++){
                int ID = data.readByte();
                String name = data.readUTF();
                String description = data.readUTF();
                int parentID = data.readByte();
                int numTags = data.readByte();

                List<Integer> tagIDs = new ArrayList<Integer>();
                for (int j = 0; j < numTags; j++){
                    tagIDs.add((int)data.readByte());
                }

                int orderInView = data.readByte();
                addTask(ID, name, description, parentID, tagIDs, orderInView);
                maxID = Math.max(maxID, ID);
            }
            maxID++;
        }
        catch(Exception excuse){
            excuse.printStackTrace();
        }
    }

    public void addTask(int ID, String name, String description, int parentID, List<Integer> tagIDs, int orderInView){
        Task newTask = new Task(ID, name, description, parentID, tagIDs, orderInView);
        tasks.add(newTask);

        //Tmp method for outputing current tasks
        printTasks();
    }

    public void addTask(String name, String description){
        Task newTask = new Task(maxID, name, description, -1, new ArrayList<Integer>(), maxID);
        maxID++;
        tasks.add(newTask);

        //Tmp method for outputing current tasks
        printTasks();
    }

    public void removeTask(int ID){
        tasks.removeIf(t -> t.getID() == ID);
    }

    public Task getTask(int ID){
        for (Task task : tasks) {
            if (task.getID() == ID)
                return task;
        }
        //TODO: propper error handling
        return null;
    }

    public void clearTasks(){
        tasks = new ArrayList<Task>();
    }

    public void printTasks()
    {
        for (Task task : tasks) {
            System.out.print("ID: " + task.getID() + ", ");
            System.out.print("Name: " + task.getName() + ", ");
            System.out.print("Description: " + task.getDescription() + ", ");
            System.out.print("Parent ID: " + task.getParentID() + ", ");
            System.out.print("Order in view: " + task.getOrderInView() + ", ");

            List<Integer> tagIDs = task.getTags();
            System.out.print("Number of tags: " + tagIDs.size() + ", tags: ");
            for(Integer tag : tagIDs){
                System.out.print(tag + ", ");
            }
            System.out.println("");
        }
        System.out.println("|============================================|");
    }
}
