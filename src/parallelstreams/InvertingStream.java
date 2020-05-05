package parallelstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
There is a new challenge. Someone has not correctly chosen the types of streams in a program (parallel and sequential).

You need to implement a method that inverses the state of every stream from the given list (parallel → sequential and vice versa).

The method should return a new list of streams which are inverted.

Try to use streams to solve this problem.
 */

public class InvertingStream {

    private static List<LongStream> invertedStreams(List<LongStream> streams) {
        // write your code here

        return streams.stream()
                .map(x -> x.isParallel() ? x.sequential() : x.parallel())
                .collect(Collectors.toList());

    }

    /* Do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Boolean> parallelFlags = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());

        // :)
        List<LongStream> streams = Stream
                .iterate(0,
                        i -> i < parallelFlags.size(),
                        i -> i + 1)
                .map(i -> {
                    var stream = LongStream.of();
                    if (parallelFlags.get(i)) {
                        stream = stream.parallel();
                    }
                    return stream;
                }).collect(Collectors.toList());

        List<String> invertedParallelFlagsAsStrings =
                invertedStreams(streams).stream()
                        .map(LongStream::isParallel)
                        .map(Object::toString)
                        .collect(Collectors.toList());

        System.out.println(String.join(" ", invertedParallelFlagsAsStrings));
    }
}
