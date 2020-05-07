package sort.bubblesort;

import java.util.Arrays;
import java.util.Scanner;

/*
For a given array, using Bubble sorting, count the number of swaps (exchanges of two numbers) you need to do to fully sort the array in the descending order. You need to output the number of swaps.
 */

public class DescendingSort {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        System.out.println(bubbleSort(array));
    }

    public static int bubbleSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */
                if (array[j - 1] < array[j]) {
                    count++;
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }

        }

        return count;
    }
}
