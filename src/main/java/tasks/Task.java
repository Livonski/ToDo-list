package src.main.java.tasks;

import java.io.ByteArrayOutputStream;
import java.util.List;

import src.main.java.saves.ISavable;

public class Task implements ISavable{
    private Integer ID;
    private String name;
    private String description;

    private int parentID;
    private List<Integer> tags;
    private int orderInView;

    public Task(Integer ID, String name, String description, int parentID, List<Integer> tagIDs,  int orderInView){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.parentID = parentID;
        tags = tagIDs;
        this.orderInView = orderInView;
    }

    public byte[] save(){
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(ID);
        byte[] nameLength = {0, (byte)(name.getBytes().length)};
        data.write(nameLength, 0, 2);
        data.writeBytes(name.getBytes());

        byte[] descLength = {0, (byte)description.getBytes().length};
        data.write(descLength, 0, 2);
        data.writeBytes(description.getBytes());

        data.write(parentID);

        data.write(tags.size());
        for(Integer tag : tags){
            data.write(tag);
        }
        data.write(orderInView);
        return data.toByteArray();
    }

    public Integer getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
       return description;
    }

    public int getParentID(){
        return parentID;
    }

    public List<Integer> getTags(){
        return tags;
    }

    public int getOrderInView(){
        return orderInView;
    }
}
