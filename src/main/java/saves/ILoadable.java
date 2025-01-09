package src.main.java.saves;

import java.io.DataInputStream;

public interface ILoadable {
    public void load(DataInputStream buffer);
}
