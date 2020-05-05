package reductionmethods;

/*
Implement the provided method rangeQuadraticSum that takes range borders (fromIncl - inclusive, toExcl - exclusive) and calculates the sum of the squares of the elements which belong to the range.
Sample Input 1:

10 12
Sample Output 1:

221
 */

import java.util.stream.LongStream;

public class RangeQuadraticSum {
    public static void main(String[] args) {
        System.out.println(rangeQuadraticSum(10,12));
    }

    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return LongStream.range(fromIncl, toExcl).reduce(0, (acc, elem) -> acc+elem*elem);
    }
}
