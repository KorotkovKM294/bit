package ru.sbt.bit.design.lesson13;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public class LoggedCommad implements Command {
    private final Command command;

    public LoggedCommad(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println(command.toString() + " execute");
        command.execute();
    }

    @Override
    public void undo() {
        System.out.println(command.toString() + " undo");
        command.undo();
    }
}
