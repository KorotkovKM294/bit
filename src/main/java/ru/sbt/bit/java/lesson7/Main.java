package ru.sbt.bit.java.lesson7;

/**
 * Created on 14.11.2016.
 *
 * Когда мы запускаем программу, она
 * неявно запускается в потоке
 *
 * + поток не обязан видеть изменения переменных
 * в других потоках (квлючая главный)
 *
 * @author Kirill M. Korotkov
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            // Можно перелпределять run у Thread
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1_000_000; j++) {
                        System.out.println(finalI + " " + j);
                    }
                }
            });
            thread.start(); // поток стартуется, и одновременно продолжается выполнение кода
        }

        Thread.sleep(1000); // обращаясь к Thread, мы обращаемся к текущему потоку

        System.out.println("END");
    }
}
