package arraysum;

import java.util.Arrays;

public class ArraySum {

    public int sum(Integer[] numbers) {
        return Arrays.stream(numbers)
                .filter(x -> x % 2 == 0)
                .map(x -> (int) Math.pow(x, 2))
                .reduce((left, right) -> left + right).get();
    }
}
