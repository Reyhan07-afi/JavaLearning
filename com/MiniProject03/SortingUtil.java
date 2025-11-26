package com.MiniProject03;
import java.util.Arrays;
public class SortingUtil {

        /**
         * Bubble Sort Algorithm
         * Time Complexity: O(n²)
         */
        public static int[] bubbleSort(int[] arr) {
            int[] a = arr.clone();
            int n = a.length;
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) break;
            }
            return a;
        }

        /**
         * Insertion Sort
         * Time Complexity: O(n²)
         */
        public static int[] insertionSort(int[] arr) {
            int[] a = arr.clone();

            for (int i = 1; i < a.length; i++) {
                int key = a[i];
                int j = i - 1;

                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = key;
            }
            return a;
        }

        /**
         * Merge Sort – Divide & Conquer
         * Time Complexity: O(n log n)
         */
        public static int[] mergeSort(int[] arr) {
            int[] a = arr.clone();
            mergeSortRec(a, 0, a.length - 1);
            return a;
        }

        private static void mergeSortRec(int[] a, int left, int right) {
            if (left >= right) return;

            int mid = (left + right) / 2;

            mergeSortRec(a, left, mid);
            mergeSortRec(a, mid + 1, right);

            merge(a, left, mid, right);
        }

        private static void merge(int[] a, int left, int mid, int right) {
            int[] L = Arrays.copyOfRange(a, left, mid + 1);
            int[] R = Arrays.copyOfRange(a, mid + 1, right + 1);
            int i = 0, j = 0, k = left;

            while (i < L.length && j < R.length) {
                a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
            }
            while (i < L.length) a[k++] = L[i++];
            while (j < R.length) a[k++] = R[j++];
        }

        /**
         * QuickSort
         * Time Complexity: Average O(n log n), Worst O(n²)
         */
        public static int[] quickSort(int[] arr) {
            int[] a = arr.clone();
            quickSortRec(a, 0, a.length - 1);
            return a;
        }

        private static void quickSortRec(int[] a, int low, int high) {
            if (low < high) {
                int p = partition(a, low, high);
                quickSortRec(a, low, p - 1);
                quickSortRec(a, p + 1, high);
            }
        }

        private static int partition(int[] a, int low, int high) {
            int pivot = a[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (a[j] <= pivot) {
                    i++;
                    int t = a[i]; a[i] = a[j]; a[j] = t;
                }
            }

            int t = a[i + 1];
            a[i + 1] = a[high];
            a[high] = t;

            return i + 1;
        }
    }


