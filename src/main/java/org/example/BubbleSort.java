package org.example;


public class BubbleSort {
    public static void main(String[] args) {
        // Example 1 input
        int[] arr1 = {4, 1, 3, 9, 7};
        System.out.println("Before sorting Example 1: ");
        printArray(arr1);

        // Sorting array of Example 1
        bubbleSort(arr1);
        System.out.println("After sorting Example 1: ");
        printArray(arr1);

        // Example 2 input
        int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Before sorting Example 2: ");
        printArray(arr2);

        // Sorting array of Example 2
        bubbleSort(arr2);
        System.out.println("After sorting Example 2: ");
        printArray(arr2);
    }

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swapping elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();  // Move to the next line
    }
}
