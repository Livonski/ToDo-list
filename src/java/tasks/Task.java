package src.java.tasks;

import java.io.ByteArrayOutputStream;

import src.java.saves.ISavable;

public class Task implements ISavable{
    private Integer ID;
    private String name;
    private String description;

    public Task(Integer ID, String name, String description){
        this.ID = ID;
        this.name = name;
        this.description = description;
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

        System.out.println("Saving task " + ID + " " + data.toString());
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
}
