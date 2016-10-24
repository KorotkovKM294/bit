package ru.sbt.bit.java.lesson5;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 */
public class WeddingFailedException extends RuntimeException {
    public WeddingFailedException() {
        super();
    }

    public WeddingFailedException(String message) {
        super(message);
    }

    public WeddingFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeddingFailedException(Throwable cause) {
        super(cause);
    }

    protected WeddingFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
