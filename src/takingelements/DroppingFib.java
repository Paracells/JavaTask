package takingelements;

import java.util.List;
import java.util.stream.Collectors;

public class DroppingFib {
    public static void main(String[] args) {
        List<Integer> fibonacci = List.of(0, 1, 1, 2, 3, 5, 8, 13);

        List<Integer> result = fibonacci.stream()
                .dropWhile(n -> n > 5)
                .collect(Collectors.toList());
        result.forEach(x -> System.out.print(x + " "));
    }
}
