package parallelstreams;

import java.util.Scanner;
import java.util.stream.*;

/*
You need to create a prepared parallel LongStream for filtering prime numbers in the given range (inclusive both borders). After calling the count() method it should return the count of prime numbers in the given range. Pay attention to the method template.

The static method NumberUtils.isPrime(someLong) is already available for you. It returns true if the passed value is prime and false otherwise.

Please, be carefully with the rangeClosed, iterate and limit methods!
PS: it's not a very efficient approach for generating prime numbers, it's just an example of parallel calculations with streams.
 */

class ParallelFilteringStream {

    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end).filter(NumberUtils::isPrime).parallel();
    }

    /* Please do not modify the code below */

public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] vals = scanner.nextLine().split(" ");

        final long left = Long.valueOf(vals[0]);
        final long right = Long.valueOf(vals[1]);

        final LongStream stream = createPrimesFilteringStream(left, right);

        if (!stream.isParallel()) {
            throw new NoParallelStreamException(
                    "You need to write a parallel stream, not sequential!");
        }

        final Long count = stream.boxed().count();

        System.out.println(count);
    }

    public static class NumberUtils {

        public static boolean isPrime(long n) {
            return n > 1 && LongStream
                    .rangeClosed(2, n - 1)
                    .noneMatch(divisor -> n % divisor == 0);
        }
    }

    static class NoParallelStreamException extends RuntimeException {

        public NoParallelStreamException(String text) {
            super(text);
        }
    }
}

public class PrimeNumbers {
}
