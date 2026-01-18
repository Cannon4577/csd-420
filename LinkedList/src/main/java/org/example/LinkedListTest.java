package org.example;

import java.util.LinkedList;
import java.util.Iterator;
//Cannon Rivera
//1/18/2026
//This program tests the time it takes to Iterate through a large amount of Integers
//vs the amount of time it takes to get(index) through the same amount of Integers

//The expected result should be a considerably faster time Iterating vs Searching
//After Testing the results were as follows:
//Iterator time for 50000: 3 ms
//get(index) time for 50000: 1053 ms
//Iterator time for 500000: 6 ms
//get(index) time for 500000: 207877 ms
//After multiple tests the results were very easy to see that It takes a much larger
//Time searching using get(index) then to use an Iterator. This is what LinkedList is known for.
import java.util.LinkedList;


public class LinkedListTest {

    public static void main(String[] args) {

        traversalTime(50000);
        traversalTime(500000);
    }

    public static void traversalTime(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        long sum1 = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sum1 += it.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("Iterator time for " + size + ": " + (end - start) + " ms");

        start = System.currentTimeMillis();
        long sum2 = 0;
        for (int i = 0; i < list.size(); i++) {
            sum2 += list.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("get(index) time for " + size + ": " + (end - start) + " ms");

    }
}
