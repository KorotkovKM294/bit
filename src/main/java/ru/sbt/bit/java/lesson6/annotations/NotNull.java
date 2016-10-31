package ru.sbt.bit.java.lesson6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 31.10.2016.
 *
 * @author Kirill M. Korotkov
 */
@Target(ElementType.FIELD)                       // Над какими элементами ставится
@Retention(RetentionPolicy.CLASS)                // На каком этапе она доступна
public @interface NotNull {
}
