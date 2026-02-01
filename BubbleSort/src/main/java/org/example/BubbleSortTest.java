package org.example;

import java.util.Comparator;
import java.util.Arrays;
//Cannon Rivera
//2/1/2026
//CSD420-T301 Advanced Java Programming
//This programs uses Comparable and Comparator to put lists of numbers, words, and People in order

public class BubbleSortTest {

    public static void main(String[] args) {

        Integer[] nums = {5, 2, 9, 1, 3};
        bubbleSort(nums);
        System.out.println("Numbers in Order: " + Arrays.toString(nums));

        String[] words = {"pear", "apple", "orange"};
        bubbleSort(words);
        System.out.println("Words in Alphebetical Order: " + Arrays.toString(words));

        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 22),
                new Person("Charlie", 25)
        };

        bubbleSort(people, Comparator.comparingInt(p -> p.age));
        System.out.println("People Sorted by Age: " + Arrays.toString(people));
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static <T> void bubbleSort(T[] array, Comparator<T> comp) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

