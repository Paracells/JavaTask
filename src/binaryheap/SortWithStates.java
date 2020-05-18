package binaryheap;

import java.util.Arrays;
import java.util.Scanner;

/*
You're given an array of elements. Your task is to sort it in ascending order using binary heap. Print not only the sorted array, but also the initial state of the heap and its states after extracting every element.


Input: In the first line is N - the length of the array. In the next line are elements of the array - N whole numbers, each is no more than 10^910
9
  in absolute value. (1\leq N \leq 1001≤N≤100).


Output: In the first line print the heap that was constructed after calling minHeap(), and in the following N-1 lines print heap states after removing next element. In the last (N+1-th) line print the sorted array.
 */
public class SortWithStates {
}


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        MinHeap heap = new MinHeap(arr, len);
        heap.printHeap();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.println();
            result[i] = heap.remove();
            heap.printHeap();
        }
        for (int i = 0; i < result.length - 1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(result[result.length - 1]);

    }
}


class MinHeap {
    private int[] minHeap;
    private int size;


    public MinHeap(int maxSize) {
        minHeap = new int[maxSize];
    }


    public MinHeap(int[] arr, int maxSize) {
        minHeap = new int[Math.max(maxSize, arr.length)];
        System.arraycopy(arr, 0, minHeap, 0, arr.length);
        size = arr.length;
        int pos = (size - 2) / 2;
        while (pos >= 0) {
            shiftDown(pos, size - 1);
            pos--;
        }
    }


    private void shiftUp(int start) {
        int j = start;
        int i = (j - 1) / 2;
        int temp = minHeap[j];
        while (j > 0) {
            if (minHeap[i] <= temp) {
                break;
            } else {
                minHeap[j] = minHeap[i];
                j = i;
                i = (j - 1) / 2;
            }
        }
        minHeap[j] = temp;
    }


    private void shiftDown(int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = minHeap[i];
        while (j <= end) {
            if (j < end) {
                j = minHeap[j] < minHeap[j + 1] ? j : j + 1;
            }
            if (temp < minHeap[j]) {
                break;
            } else {
                minHeap[i] = minHeap[j];
                i = j;
                j = 2 * i + 1;
            }
        }
        minHeap[i] = temp;
    }


    public void insert(int data) {
        if (size == minHeap.length) {
            throw new RuntimeException("Heap Full");
        }
        if (size < minHeap.length) {
            minHeap[size] = data;
            shiftUp(size);
            size++;
        }
    }


    public int remove() {
        if (size == 0) {
            throw new NullPointerException("Heap Null");
        }
        int x = minHeap[0];
        minHeap[0] = minHeap[--size];
        shiftDown(0, size);
        return x;
    }

    public void heapSort() {
        for (int i = size - 1; i >= 0; i--) {
            int temp = minHeap[0];
            minHeap[0] = minHeap[i];
            minHeap[i] = temp;
            shiftDown(0, i - 1);
        }
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(minHeap[i] + " ");
        }
    }


    public void printMinHeap(int i) {
        if (size > i) {
            System.out.print(minHeap[i]);
            if (2 * i + 1 < size || 2 * i + 2 < size) {
                System.out.print("(");
                printMinHeap(2 * i + 1);
                System.out.print(",");
                printMinHeap(2 * i + 2);
                System.out.print(")");
            }
        }
    }

    public void printHeap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(minHeap[i]).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
