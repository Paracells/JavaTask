package sort.selectionsort;

import java.util.Scanner;

/*
At each step, Selection sort finds the smallest (largest) element in an unsorted part of an array and places the found element to the end of a sorted part. So, after kk iterations are completed, the first kk elements are the smallest (largest) elements of the array in ascending (descending) order. This property allows us to implement a partial sorting algorithm which runs in O(k \cdot n)O(k⋅n) for an array of size nn. Your task here is to implement such an algorithm by modifying Selection sort.
Input: the first line contains a number nn — the length of an input array. The next line contains nn numbers — the elements of the array. The 3rd line contains an integer kk.
Output: kk largest elements of the input array in descending order.
 */

public class PartialSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.next());
        }
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
