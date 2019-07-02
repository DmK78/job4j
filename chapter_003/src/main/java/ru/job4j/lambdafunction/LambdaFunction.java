package ru.job4j.lambdafunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaFunction {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i < end; i++) {
            double value = func.apply(i);
            result.add(value);
        }
        return result;

    }

}
