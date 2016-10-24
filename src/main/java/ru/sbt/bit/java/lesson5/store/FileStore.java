package ru.sbt.bit.java.lesson5.store;

import java.io.*;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public class FileStore implements Store {
    @Override
    public void save(String line) {
        try (FileWriter stream = new FileWriter("file.txt")) {
            stream.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get() {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
