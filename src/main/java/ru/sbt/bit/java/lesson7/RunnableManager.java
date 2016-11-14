package ru.sbt.bit.java.lesson7;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public interface RunnableManager {

    /**
     * Управление передается в callback после выполнения всех runnables.
     * @param callback
     * @param runnables
     */
    void run(Runnable callback, Runnable...runnables);
}
