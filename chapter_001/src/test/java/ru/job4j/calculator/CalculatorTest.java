package ru.job4j.calculator;

import org.junit.Test;
import ru.jobs4j.calculator.Calculator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Dmitry Kolganov (dmk78@inbox.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest  {
    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */
    @Test
    public void whenTwoMinusOneThenOne()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(2D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenFourDivByTwoThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.div(4D, 2D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiply.
     */
    @Test
    public void whenTwoMultiplyByThreeThenSix()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(2D, 3D);
        double expected = 6D;
        assertThat(result, is(expected));
    }
}