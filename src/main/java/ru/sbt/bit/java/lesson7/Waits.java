package ru.sbt.bit.java.lesson7;

import java.util.Random;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Waits {
    static Object lock = new Object();
    private volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (i == 0) {
                        try {
                            lock.wait();    // отпускает монитор
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("exit from wait");
                }
            }
        };
        thread.start();
//        Thread.sleep(1);
        synchronized (lock) {
            i = new Random().nextInt(); // избегаем missing call
            lock.notify();  // пробуждается не сразу. notify пробуждает случайный поток, а notifyAll - все
            System.out.println("notify");
        }   // а только после блока synchronized
    }
}
