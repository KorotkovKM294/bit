package ru.sbt.bit.java.lesson8;

/**
 * Created on 21.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class TaskManagerImpl implements TaskManager {

    @Override
    public Context execute(Runnable... runnables) {
        Context context = new ContextImpl();
        for (Runnable runnable : runnables) {
            Runnable r = new RunnableTask(runnable, context);
            Thread thread = new Thread(runnable);
            thread.start();
        }
        return null;
    }

    class ContextImpl implements Context {
        @Override
        public int getFinishedTaskCount() {
            return 0;
        }

        @Override
        public int getFailedTaskCount() {
            return 0;
        }

        @Override
        public int getSuccessFinishedTaskCount() {
            return 0;
        }

        @Override
        public void stop() {

        }
    }

}
