package reductionmethods;

import java.util.stream.LongStream;

public class CalculatingFactorials {
    public static void main(String[] args) {
        System.out.println(factorial(2));

    }

    public static long factorial(long n) {
        // write your code here
        return LongStream.rangeClosed(1, n).reduce(1, (acc, elem) -> acc * elem);
    }
}
