package ru.sbt.bit.java.lesson5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Exceptions.
 */
public class Main {

    public static void main(String[] args) {
        try {
            run();
        } catch (ArithmeticException e) {
            System.out.println("Exception");
        }
    }

    private static void run() {
        System.err.println("Run start");
        FileOutputStream fileOutputStream = null;
        try {
            work();
            System.out.println("Run success");
            fileOutputStream = new FileOutputStream("file.txt");
            fileOutputStream.write("Hello".getBytes());
            fileOutputStream.write("World".getBytes());
        } catch (ArithmeticException e) {
            System.out.println("Run exception");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();                   // Как-то не очень выглядит
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Run end");
    }

    private static void betterRun() {
        try(FileOutputStream stream = new FileOutputStream("file.txt")) {   // Это называется try with resources
            stream.write("Hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void work() throws FileNotFoundException {
        int x = 5;
        int y = 0;

        if (y == 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("WORK!");

        int x1 = x / y;

        System.out.println(x1);

        ++x1;
        System.out.println("END");
    }
}
