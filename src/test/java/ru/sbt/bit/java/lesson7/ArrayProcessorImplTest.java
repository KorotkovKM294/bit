package ru.sbt.bit.java.lesson7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on 14.11.2016.
 *
 * @author Kirill M. Korotkov
 */
public class ArrayProcessorImplTest {
    @Test
    public void process() throws Exception {
        ArrayProcessor p = new ArrayProcessorImpl();
        ArrayProcessor.ElementStrategy strategy = new ArrayProcessor.ElementStrategy() {
            @Override
            public int process(int i) {
                return i * 10;
            }
        };
        int[] a = {10, 10, 50, 50, 30, 47, 54, 545, 45, 54};
        int[] expected = {100, 100, 500, 500, 300, 470, 540, 5450, 450, 540};

        int[] result = p.process(a, strategy, 2);

        for (int i = 0; i < result.length; i++) {
            Assert.assertArrayEquals(expected, result);
        }

        result = p.process(a, strategy, 7);

        for (int i = 0; i < result.length; i++) {
            Assert.assertArrayEquals(expected, result);
        }
    }

}