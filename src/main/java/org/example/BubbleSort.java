package org.example;


public class BubbleSort {
    public static void main(String[] args) {
        // Example 1 input
        int[] array1 = {4, 1, 3, 9, 7};
        System.out.println("Before sorting Example 1: ");
        printArray(array1);

        // Sorting array of Example 1
        bubbleSort(array1);
        System.out.println("After sorting Example 1: ");
        printArray(array1);

        // Example 2 input
        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Before sorting Example 2: ");
        printArray(array2);

        // Sorting array of Example 2
        bubbleSort(array2);
        System.out.println("After sorting Example 2: ");
        printArray(array2);
    }

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (array[j] > array[j + 1]) {
                    // Swapping elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();  // Move to the next line
    }
}
