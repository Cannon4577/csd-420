//Cannon Rivera  12/21/2025 RemoveDuplicates/3.2
//This program creates an arraylist of 50 random numbers (1-20)
//and then runs it through a removeDuplicates method that removes
//all duplicate numbers and then returns a new list of numbers.

package org.example;

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> firstlist = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            firstlist.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original ArrayList:");
        System.out.println(firstlist);

        ArrayList<Integer> newlist = removeDuplicates(firstlist);

        System.out.println("\nArrayList with duplicates removed:");
        System.out.println(newlist);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> firstlist) {
        ArrayList<E> newList = new ArrayList<>();

        //checks new list if it has number, if not it adds it, if so it moves on
        for ( E element : firstlist) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
