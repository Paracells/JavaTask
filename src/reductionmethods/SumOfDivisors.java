package reductionmethods;

import java.util.Scanner;
import java.util.stream.LongStream;

/*
For a given range from A to B both inclusive, count sum of numbers that are only divisible by N or M. Use streams to solve the problem.
For example, for range from 10 to 20 and N = 2, M = 3, there are 6 numbers that are divisible by N or M - 10, 12, 14, 15, 16, 18, 20. And their sum equals 105.
 */
public class SumOfDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(LongStream.rangeClosed(a, b)
                .filter(x -> x % n == 0 || x % m == 0)
                .reduce(0, Long::sum));
    }
}
