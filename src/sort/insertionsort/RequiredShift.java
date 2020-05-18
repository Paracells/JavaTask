package sort.insertionsort;

import java.util.Arrays;
import java.util.Scanner;

public class RequiredShift {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(insertionSort(array));
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    /*public static int insertionSort(int[] array) {
        int count = 0;
        *//* iterating over elements in the unsorted part *//*
        for (int i = 1; i < array.length; i++) {
            int elem = array[i]; // take the next element
            int j = i;

            *//* find a suitable position to insert and shift elements to the right *//*
            while (j > 0 && array[j - 1] < elem) {
                count++;
                array[j] = array[j - 1]; // shifting
                j--;
            }
            array[j] = elem; // insert the element in the found position in the sorted part
        }

        return count;
    }*/

    public static int insertionSort(int[] array) {
        int count = 0;
        /* iterating over elements in the unsorted part */
        for (int i = 1; i < array.length; i++) {
            int elem = array[i]; // take the next element
            int j = i - 1;

            /* find a suitable position to insert and shift elements to the right */
            while (j >= 0 && array[j] < elem) {
                count++;
                array[j + 1] = array[j]; // shifting
                j--;
            }
            array[j + 1] = elem; // insert the element in the found position in the sorted part
        }

        return count;
    }
}
