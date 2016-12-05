package ru.sbt.bit.design.lesson13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public class CommandExecutor {
    private final List<Command> commands = new ArrayList<>();

    public void run(Command command) {
        commands.add(command);
        command.execute();
    }

    public void undoLastCommands(int count) {
        if (commands.size() < count) {
            throw new IllegalArgumentException("");
        }
        for (int i = 0; i < count; i++) {
            Command command = commands.remove(commands.size() - 1);
            command.undo();
        }
    }
}
