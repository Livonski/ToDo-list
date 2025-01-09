package src.main.java.tags;

import java.io.ByteArrayOutputStream;

import javafx.scene.paint.Color;
import src.main.java.saves.ISavable;

public class Tag implements ISavable {
    private String name;
    private int ID;
    private Color color;

    public Tag(String name, int ID, Color color){
        this.name = name;
        this.ID = ID;
        this.color = color;
    }

    public byte[] save(){
        ByteArrayOutputStream bAStream = new ByteArrayOutputStream();
        byte[] nameLength = {0, (byte)name.getBytes().length};
        bAStream.write(nameLength, 0, 2);
        bAStream.writeBytes(name.getBytes());

        bAStream.write(ID);
        bAStream.write((byte)color.getRed());
        bAStream.write((byte)color.getGreen());
        bAStream.write((byte)color.getBlue());

        return bAStream.toByteArray();
    }

    public Integer getID() {
        return ID;
    }

    public String getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }
}
