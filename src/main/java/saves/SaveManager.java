package src.main.java.saves;

import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private List<ISavable> savables;
    private List<ILoadable> loadables;
    private File saveFile;
    private String filename = "save.bin";
    private int currentVersion = 1;

    public SaveManager(){
        savables = new ArrayList<ISavable>();
        loadables = new ArrayList<ILoadable>();
        saveFile = new File(filename);
    }

    public void save(){
        if(savables == null){
            return;
        }

        try(FileOutputStream fos = new FileOutputStream(saveFile, false);
            DataOutputStream dos = new DataOutputStream(fos)){
            
            int saveLength = 12;
            dos.writeInt(currentVersion);
            ByteArrayOutputStream bAStream = new ByteArrayOutputStream();
            for (ISavable savable : savables) {
                byte[] data = savable.save();
                bAStream.writeBytes(data);
                saveLength += data.length;
            }
            dos.writeLong(saveLength);
            dos.write(bAStream.toByteArray());

            fos.close();
            dos.close();
        } catch(Exception excuse){
            excuse.printStackTrace();
        }
    }

    public void load(){
        try(FileInputStream fis = new FileInputStream(saveFile);
            DataInputStream dis = new DataInputStream(fis)){
            long fileSize = saveFile.length();

            int version = dis.readInt();
            if(version != currentVersion)
                throw new Exception("Failed to load save, file version("+ version +") doesn't match current version("+ currentVersion +")");
                
            long declaredSize = dis.readLong();
            if(declaredSize != fileSize)
                throw new Exception("Failed to load file, declared file size(" + declaredSize + ") != to actual size(" + fileSize + ")");
            
            loadables.get(0).load(dis);
            fis.close();
            dis.close();
        } catch(Exception excuse){
            excuse.printStackTrace();
        }
    }

    public void addSavable(ISavable savable){
        savables.add(savable);
    }

    public void addLoadable(ILoadable loadable){
        loadables.add(loadable);
    }
}
