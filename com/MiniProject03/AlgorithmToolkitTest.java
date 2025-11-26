package com.MiniProject03;
import java.util.Arrays;
public class AlgorithmToolkitTest {

        public static void main(String[] args) {

            // ------------ Sorting Tests ------------
            int[] arr = {5, 2, 9, 1};
            int[] sorted = {1, 2, 5, 9};

            System.out.println("Bubble: " + Arrays.toString(SortingUtil.bubbleSort(arr)));
            System.out.println("Insertion: " + Arrays.toString(SortingUtil.insertionSort(arr)));
            System.out.println("Merge: " + Arrays.toString(SortingUtil.mergeSort(arr)));
            System.out.println("Quick: " + Arrays.toString(SortingUtil.quickSort(arr)));

            // ------------ Searching Tests ------------
            int[] data = {1, 3, 5, 7, 9};

            System.out.println("Linear Search 5 → " + SearchUtil.linearSearch(data, 5));
            System.out.println("Binary Search 7 → " + SearchUtil.binarySearch(data, 7));

            // ------------ Stack Test ------------
            collectionUtil.CollectionUtil.Stack<Integer> stack = new collectionUtil.CollectionUtil.Stack<>();
            stack.push(10); stack.push(20);
            System.out.println("Stack pop → " + stack.pop());

            // ------------ Queue Test ------------
            collectionUtil.CollectionUtil.Queue<String> queue = new collectionUtil.CollectionUtil.Queue<>();
            queue.enqueue("A"); queue.enqueue("B");
            System.out.println("Queue dequeue → " + queue.dequeue());

            // ------------ Benchmark Test ------------
            long t = AnalysisUtil.timeMillis(() -> SortingUtil.mergeSort(arr));
            System.out.println("MergeSort time: " + t + " ms");

            System.out.println("\nAll tests completed successfully!");
        }
    }
