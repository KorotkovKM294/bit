package ru.sbt.bit.design.lesson13;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyril Korotkov on 30.11.2016.
 */
public class TestCommand {

    @Test
    public void TestAppendCommand() {
        List<String> testList = new ArrayList<>();
        String appendedText = "text1";
        Command appendText = new AppendTextCommand(testList, appendedText);
        CommandExecutor ce = new CommandExecutor();
        ce.run(appendText);

        Assert.assertEquals(appendedText, testList.get(0));
    }

    @Test
    public void TestUndoCommand() {
        List<String> testList = new ArrayList<>();
        String appendedText = "text1";
        String appendedText2 = "text1";
        String appendedText3 = "text3";
        Command appendText = new AppendTextCommand(testList, appendedText);
        Command appendText2 = new AppendTextCommand(testList, appendedText2);
        Command appendText3 = new AppendTextCommand(testList, appendedText3);
        CommandExecutor ce = new CommandExecutor();
        ce.run(appendText);
        ce.run(appendText2);
        ce.run(appendText3);

        ce.undoLastCommands(2);

        Assert.assertEquals(testList.size(), 1);
    }

    @Test
    public void testSurroundCommand() {
        List<String> testList = new ArrayList<>();
        String appendedText = "text1";
        String appendedTextBefore = "text2";
        String appendedTextAfter = "text3";
        Command appendText = new AppendTextCommand(testList, appendedText);
        CommandExecutor ce = new CommandExecutor();
        ce.run(appendText);
        Assert.assertEquals(appendedText, testList.get(0));

        Command surroundText = new SurroundTextCommand(testList, appendedTextBefore, appendedTextAfter);
        ce.run(surroundText);
        Assert.assertEquals(appendedTextBefore, testList.get(0));
        Assert.assertEquals(appendedTextAfter, testList.get(2));
    }

    @Test
    public void testUndoSurroundCommand() {
        List<String> testList = new ArrayList<>();
        String appendedText = "text1";
        String appendedTextBefore = "text2";
        String appendedTextAfter = "text3";
        Command appendText = new AppendTextCommand(testList, appendedText);
        CommandExecutor ce = new CommandExecutor();
        ce.run(appendText);
        Assert.assertEquals(appendedText, testList.get(0));

        Command surroundText = new SurroundTextCommand(testList, appendedTextBefore, appendedTextAfter);
        ce.run(surroundText);
        Assert.assertEquals(appendedTextBefore, testList.get(0));
        Assert.assertEquals(appendedTextAfter, testList.get(2));

        ce.undoLastCommands(1);
        Assert.assertEquals(1, testList.size());
        Assert.assertEquals(appendedText, testList.get(0));
    }

    @Test
    public void testLoggedCommands() {
        List<String> testList = new ArrayList<>();
        String appendedText = "text1";
        String appendedTextBefore = "text2";
        String appendedTextAfter = "text3";
        Command appendText = new LoggedCommad(new AppendTextCommand(testList, appendedText));
        CommandExecutor ce = new CommandExecutor();
        ce.run(appendText);
        Assert.assertEquals(appendedText, testList.get(0));

        Command surroundText = new LoggedCommad(new SurroundTextCommand(testList, appendedTextBefore, appendedTextAfter));
        ce.run(surroundText);
        Assert.assertEquals(appendedTextBefore, testList.get(0));
        Assert.assertEquals(appendedTextAfter, testList.get(2));

        ce.undoLastCommands(1);
        Assert.assertEquals(1, testList.size());
        Assert.assertEquals(appendedText, testList.get(0));
    }
}
