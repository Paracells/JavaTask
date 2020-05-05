package takingelements;

/*
 You've found a sequence of codes on the Internet in the HEX format (hexadecimal numbers). You have an assumption that this sequence has a secret subsequence enclosed between "#0000" and "#FFFF". Apply your knowledge of Stream API to extract all codes between them (excluding both "#0000" and "#FFFF").
Please, try to use takeWhile and dropWhile methods as well as some predicate to solve this problem.

Sample Input 1:

#88D4 #0000 #ACCD #444C #FFFF #5E62
Sample Output 1:

#ACCD #444C
Sample Input 2:

#0000 #AAAA #FFFF
Sample Output 2:

#AAAA
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SecretCodes {

    private static List<String> extractCodes(List<String> codes) {
        // write your code here
        List<String> collect = codes.stream()
                .takeWhile(s -> !s.equals("#FFFF"))
                .dropWhile(s -> !s.equals("#0000"))
                .skip(1)
                .collect(Collectors.toList());
        return collect;
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}

