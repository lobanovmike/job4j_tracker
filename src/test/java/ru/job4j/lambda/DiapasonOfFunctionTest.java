package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiapasonOfFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonOfFunction diapasonOfFunction = new DiapasonOfFunction();
        List<Double> result = diapasonOfFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        DiapasonOfFunction diapasonOfFunction = new DiapasonOfFunction();
        List<Double> result = diapasonOfFunction.diapason(3, 6, x -> 2 * x * x + 3 * x + 1);
        List<Double> expected = Arrays.asList(28D, 45D, 66D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        DiapasonOfFunction diapasonOfFunction = new DiapasonOfFunction();
        List<Double> result = diapasonOfFunction.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}