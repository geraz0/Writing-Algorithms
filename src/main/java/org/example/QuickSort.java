package org.example;

public class QuickSort {

    public static void main(String[] args) {
        // Example 1 setup: defining an array of integers
        int[] arr1 = {4, 1, 3, 9, 7};
        System.out.println("Original Array for Example 1:");
        printArray(arr1);

        // Performing Quick Sort on the array from Example 1
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println("Sorted Array for Example 1:");
        printArray(arr1);

        // Example 2 setup: defining another array of integers
        int[] arr2 = {2, 1, 6, 10, 4, 1, 3, 9, 7};
        System.out.println("Original Array for Example 2:");
        printArray(arr2);

        // Performing Quick Sort on the array from Example 2
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Sorted Array for Example 2:");
        printArray(arr2);
    }

    /**
     * Performs Quick Sort algorithm on a sub-array from index `low` to `high`.
     * Quick Sort is a divide and conquer algorithm. It picks an element as pivot
     * and partitions the given array around the picked pivot.
     *
     * @param arr Array to sort.
     * @param low Starting index of the sub-array to sort.
     * @param high Ending index of the sub-array to sort.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partitioning the array and getting the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition
            quickSort(arr, low, pi - 1);
            // Recursively sort elements after partition
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * This method takes the last element as pivot, places the pivot element at
     * its correct position in the sorted array, and places all smaller (smaller than pivot)
     * to the left of the pivot and all greater elements to the right of the pivot.
     *
     * @param arr Array to partition.
     * @param low Starting index for the partition process.
     * @param high Ending index for the partition process.
     * @return The index of the pivot element after partition.
     */
    private static int partition(int[] arr, int low, int high) {
        // Choosing the pivot element
        int pivot = arr[high];
        // Pointer for the greater element
        int i = (low - 1);

        // Traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] <= pivot) {
                i++; // increment index of smaller element
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap the pivot element with the element at index i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Utility method to print elements of the array.
     * @param arr Array to print.
     */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();  // Move to the next line
    }
}
