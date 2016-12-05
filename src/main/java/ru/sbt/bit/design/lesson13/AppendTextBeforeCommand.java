package ru.sbt.bit.design.lesson13;

import java.util.List;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public class AppendTextBeforeCommand implements Command {
    private final List<String> list;
    private final String text;

    public AppendTextBeforeCommand(List<String> list, String text) {
        this.list = list;
        this.text = text;
    }

    @Override
    public void execute() {
        list.add(0, text);
    }

    @Override
    public void undo() {
        list.remove(0);
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + list.toString() + " " + text;
    }
}
