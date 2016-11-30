package ru.sbt.bit.java.lesson7;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class Main2 {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = getThread();
        Thread thread2 = getThread();
        thread1.start();
        thread2.start();
        thread1.join();  // Дожидается, пока thread1 не закончится
        thread2.join();  // join тоже работает почти как synchronized; после того, как выполнился первый join, в следующий должна передаться инфа об измененных переменных

        System.out.println(i);
    }

    private static Thread getThread() {
        return new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100_000; j++) {
//                        ++i;
                        // когда заходим в synchronized, включается монитор
                        // указывать можно что угодно, кроме примитивных типов
                        // здесть Class, один объект
                        synchronized (Thread.class) {
                            i = i + 1; // операция не атомарная (без synchronized)
                        }
                    }
                }
            });
    }

    // Захватывается Main2.class
    private synchronized static void incr() {
        ++i;
    }

    // Main2 main = new Main2();
    // main.run();
    private synchronized void run() {
        ++i;
        // эквивалентно
        // synchronized (this) {
        //     ++i;
        // }
    }
}
