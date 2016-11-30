package ru.sbt.bit.design.lesson13;

import java.util.List;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public class SurroundTextCommand implements Command {
    private final Command appendBefore;
    private final Command appendAfter;


    public SurroundTextCommand(List<String> list, String appendedTextBefore, String appendedTextAfter) {
        this.appendBefore = new AppendTextBeforeCommand(list, appendedTextBefore);
        this.appendAfter = new AppendTextCommand(list, appendedTextAfter);
    }

    @Override
    public void execute() {
        appendBefore.execute();
        appendAfter.execute();
    }

    @Override
    public void undo() {
        appendBefore.undo();
        appendAfter.undo();
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + appendBefore.toString() + " " + appendAfter.toString();
    }
}
