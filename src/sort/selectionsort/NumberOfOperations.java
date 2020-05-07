package sort.selectionsort;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
For different arrays, Selection sort performs a different number of operations. Write a program that for a collection of arrays finds the one for which Selection sort makes the maximum number of operations.
Input: the first line contains two numbers nn and mm. Each of the following nn lines contains an array: mm numbers separates by spaces.
Output: the number of an array for which Selection sort performs the maximum number of operations among all other arrays. Assume that each array needs to be sorted in ascending order. Here, an operation is either a changing of the current minimum or exchanging the current minimum with the current index. If there are several arrays requiring the maximum number of operations, print the number of the first one.
 */

public class NumberOfOperations {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int quan = scanner.nextInt();
        int lenArray = scanner.nextInt();
        int max = sort(IntStream.range(0, lenArray).map(n -> scanner.nextInt()).toArray());
        int t = 0;
        for (int i = 1; i < quan; i++) {
            int next = sort(IntStream.range(0, lenArray).map(n -> scanner.nextInt()).toArray());
            if (max < next) {
                t = i;
                max = next;
            }

        }
        System.out.println(t + 1);

    }

    public static int sort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    count++;
                    index = j;
                }
            }
            count++;
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }
        return count;
    }
}
