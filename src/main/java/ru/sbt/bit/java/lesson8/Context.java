package ru.sbt.bit.java.lesson8;

/**
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public interface Context {

    int getFinishedTaskCount();

    int getFailedTaskCount();

    int getSuccessFinishedTaskCount();

    /**
     * Останавливает те, которые еще не завершились
     */
    void stop();
}
