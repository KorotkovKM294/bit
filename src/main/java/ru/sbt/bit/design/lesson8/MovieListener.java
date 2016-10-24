package ru.sbt.bit.design.lesson8;

import java.util.Collection;
import java.util.List;

/**
 * Created by Cyril Korotkov on 24.10.2016.
 *
 * Dependency injection
 */
public class MovieListener {

    MovieFinder finder;


    public Collection<Movie> findMovieBy(Person director) {
        return finder.findAll();
    }

    public interface MovieFinder {
        List findAll();
    }

    interface Movie {
    }

    interface Person {
    }

}
