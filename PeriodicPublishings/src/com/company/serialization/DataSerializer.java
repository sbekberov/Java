package com.company.serialization;

import com.company.entities.Periodic;

import java.io.*;

public class DataSerializer {
    public void writeData(Periodic[] data, String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(data);
    }

    public Periodic[] readData(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Periodic[] data = (Periodic[]) ois.readObject();
        return data;
    }
}
