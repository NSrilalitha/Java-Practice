package com.sorting.practice;

public class SelectionSortUsingArrays {

    /*
     * This will sort the given array of characters in alphabetical
     * order using selection sort
     */
    public void sortArrayElements(char[] letters) {
        for(int i = 0; i < letters.length - 1; i++) {
            for(int j = i + 1; j < letters.length; j++) {
                if(letters[j] < letters[i]) {
                    char temp = letters[i];
                    letters[i] = letters[j];
                    letters[j] = temp;
                }
            }
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
