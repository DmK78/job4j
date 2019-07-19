package arraysum;

import java.util.Arrays;

public class ArraySum {

    public Double sum(Integer[] numbers) {
        return Arrays.stream(numbers).filter(integer -> integer % 2 == 0).mapToDouble(value -> Math.pow(value, 2)).reduce((left, right) -> left + right).getAsDouble();
    }
}
