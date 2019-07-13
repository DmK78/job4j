package ru.job4j.lambdafunction;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LambdaFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(3 + x, 2) + 2 * x + 1);
        List<Double> expected = List.of(75D, 94D, 115D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = List.of(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(result, is(expected));
    }
}
