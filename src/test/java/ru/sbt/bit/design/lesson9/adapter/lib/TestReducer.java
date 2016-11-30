package ru.sbt.bit.design.lesson9.adapter.lib;

import org.junit.Test;
import ru.sbt.bit.design.lesson9.adapter.myImpl.MagicReduceOp;

import static org.junit.Assert.assertEquals;

public class TestReducer {

    @Test
    public void testReduceWorks() {
        int[] arr = { -1, 2, 4, 0, 5 };
        assertEquals( 10, new Reducer().reduce(arr, new MagicReduceOp()));
    }

    @Test
    public void testReduceWorksForTwoElements() {
        int[] arr = { 1, 2 };
        assertEquals( 3, new Reducer().reduce(arr, new MagicReduceOp()));
    }

    @Test
    public void testReduceWorksForOneElement() {
        int[] arr = { -1 };
        assertEquals( -1, new Reducer().reduce(arr, new MagicReduceOp()));
    }

}
