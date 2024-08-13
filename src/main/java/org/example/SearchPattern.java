package org.example;

public class SearchPattern {

    public static void main(String[] args) {
        // Example 1: Finding "bat" in the string "batmanandrobinarebat"
        String text1 = "batmanandrobinarebat";
        String pattern1 = "bat";
        System.out.println("Indexes for 'bat' in 'batmanandrobinarebat': ");
        printResults(search(text1, pattern1));

        // Example 2: Trying to find "edu" in the string "abesdu" where it does not exist
        String text2 = "abesdu";
        String pattern2 = "edu";
        System.out.println("Indexes for 'edu' in 'abesdu': ");
        printResults(search(text2, pattern2));
    }

    /**
     * Searches for all occurrences of the pattern in the given text using the Z-algorithm.
     *
     * @param text    The main text in which to search for the pattern.
     * @param pattern The pattern to search for within the main text.
     * @return An array of integers indicating the starting positions (1-based) of each occurrence of the pattern.
     */
    public static int[] search(String text, String pattern) {
        String combined = pattern + "$" + text;
        int[] Z = calculateZ(combined);
        int[] results = new int[text.length()];
        int resultCount = 0;

        // Loop through the Z array to find matching lengths equal to the pattern length
        for (int i = pattern.length() + 1; i < combined.length(); i++) {
            if (Z[i] == pattern.length()) {
                // Convert zero-based index to one-based for the results
                results[resultCount++] = (i - pattern.length() - 1) + 1;
            }
        }

        // Return only the populated part of the results array
        return java.util.Arrays.copyOf(results, resultCount);
    }

    /**
     * Computes the Z-array for a given input string.
     * Z[i] is the length of the longest substring starting from s[i] that is also a prefix of s.
     *
     * @param s The string for which to compute the Z-array.
     * @return The Z-array.
     */
    private static int[] calculateZ(String s) {
        int[] Z = new int[s.length()];
        int L = 0, R = 0;

        for (int i = 1; i < s.length(); i++) {
            if (i > R) {
                L = R = i;
                while (R < s.length() && s.charAt(R) == s.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1) {
                    Z[i] = Z[k];
                } else {
                    L = i;
                    while (R < s.length() && s.charAt(R) == s.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }

    /**
     * Prints the results of the pattern search and the number of occurrences.
     *
     * @param results Array containing the indices of matches.
     */
    private static void printResults(int[] results) {
        if (results.length == 0) {
            System.out.println("No occurrences found.");
        } else {
            System.out.println("Number of occurrences: " + results.length);
            for (int index : results) {
                System.out.println("Pattern found at index: " + index + " in the text.");
            }
        }
    }
}
