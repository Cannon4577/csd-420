package org.example;

import java.io.*;
import java.util.*;
//Cannon Rivera
//1/21/2026
//The purpose of this program is to pull a list of words from an external file
//and display them in ascending order, then descending order.

public class WordCollection {

    public static Set<String> readWordsFromFile(String fileName) throws IOException {
        Set<String> words = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String word;
        while ((word = reader.readLine()) != null) {
            words.add(word);
        }

        reader.close();
        return words;
    }

    public static void main(String[] args) {
        try {
            Set<String> words = readWordsFromFile("src/main/java/org/example/collection_of_words.txt");

            List<String> reversedwords = new ArrayList<>(words);
            System.out.println("Ascending Order:");
            reversedwords.sort(Comparator.reverseOrder());
            for (String word : reversedwords) {
                System.out.println(word);
            }


            System.out.println("Descending Order:");
            for (String word : words) {
                System.out.println(word);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
