package com.sorting.practice;

/**
 * Selection sort is not stable.
 *
 * To learn algorithm refer: https://www.geeksforgeeks.org/selection-sort/?ref=shm
 */
public class SelectionSortUsingArrays {

    /*
     * This will sort the given array of characters in alphabetical
     * order using selection sort
     */
    public void sortArrayElements(char[] letters) {
        for(int i = 0; i < letters.length - 1; i++) {
            int min_index = i;
            for(int j = i + 1; j < letters.length; j++) {
                if(letters[j] < letters[min_index]) {
                    min_index = j;
                }
            }
            // Swap the found minimum element with the first element
            char temp = letters[i];
            letters[i] = letters[min_index];
            letters[min_index] = temp;
        }
        // now print sorted array
        for(char letter : letters) {
            System.out.print(letter + " ");
        }
    }

    public static void main(String[] args) {
        // creating an array of characters
        char[] arr = {'T', 'K', 'I', 'A', 'O', 'W', 'B', 'F', 'C', 'J', 'I'};
        SelectionSortUsingArrays sorter = new SelectionSortUsingArrays();
        sorter.sortArrayElements(arr);
    }
}
