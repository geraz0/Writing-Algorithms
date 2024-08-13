package org.example;

public class CountingSort {

    public static void main(String[] args) {
        // Example 1
        String input1 = "edsab";
        System.out.println("Original String for Example 1: " + input1);
        String sorted1 = countSort(input1);
        System.out.println("Sorted String for Example 1: " + sorted1);

        // Example 2
        String input2 = "geeksforgeeks";
        System.out.println("Original String for Example 2: " + input2);
        String sorted2 = countSort(input2);
        System.out.println("Sorted String for Example 2: " + sorted2);
    }

    /**
     * Performs Counting Sort on a string of lowercase English letters.
     * Counting Sort is an efficient sorting algorithm that operates by counting the
     * number of objects that have distinct key values, and doing some arithmetic to
     * calculate the position of each object in the output sequence.
     *
     * @param input The input string to be sorted.
     * @return The sorted string.
     */
    public static String countSort(String input) {
        // Create an array to store the count of each character
        int[] count = new int[26]; // English alphabet has 26 letters
        char[] array = input.toCharArray();

        // Count each character in the input string
        for (char c : array) {
            count[c - 'a']++; // Subtract 'a' to map 'a' to index 0, 'b' to index 1, etc.
        }

        // Build the output string based on the counts
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = (char) (i + 'a'); // Convert index back to character
                count[i]--;
            }
        }

        return new String(array);
    }
}
