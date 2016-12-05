package ru.sbt.bit.design.lesson13;

import java.util.List;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public class AppendTextCommand implements Command {
    private final List<String> list;
    private final String text;

    public AppendTextCommand(List<String> list, String appendedText) {
        this.list = list;
        this.text = appendedText;
    }

    @Override
    public void execute() {
        list.add(text);
    }

    @Override
    public void undo() {
        list.remove(list.size() - 1);
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + list.toString() + " " + text;
    }
}
