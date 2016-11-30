package ru.sbt.bit.java.lesson7;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class MainVolatile {
    private volatile boolean keepRunning = true; // потоки обязаны видеть актуальное значение переменной
                                                 // volatile работает чуть быстрее, чем synchronized
    public void run() {
        int counter = 0;
        while (keepRunning) {
            ++counter;
        }
        System.out.println(counter);
    }

    public void stop() {
        keepRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {
        MainVolatile m = new MainVolatile();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.run();
            }
        });
        t1.start();

        Thread.sleep(10); // без volatile не останавливается, потому что два потока не обязаны знать изменения внешней переменной
        m.stop();         // это связано с JIT компилятором, который успевает зареплейсить откомпилированный код
        System.out.println("Main finish");
    }
}
