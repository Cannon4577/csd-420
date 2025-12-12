//Cannon Rivera FileArray 12/11/2025

//The Purpose of this program is to create and write to a file
// 5 random integers, and 5 random doubles

package org.example;


import java.io.*;
import java.util.Random;

public class FileCreation {

    public static void main(String[] args) throws IOException {

        Random rand = new Random();
        int[] intarray = new int[5];
        double[] doublearray = new double[5];

        for (int i = 0; i < 5; i++) {
            intarray[i] = rand.nextInt(100);
            doublearray[i] = rand.nextDouble() * 100;
        }


        try (PrintWriter output =
                     new PrintWriter(new FileOutputStream("file.dat", true))) {

            output.println("Integers:");
            for (int num : intarray) {
                output.print(num);
                output.print(" ");
            }
            output.println();

            output.println("Doubles:");
            for (double num : doublearray) {
                output.print(num);
                output.print(" ");
            }

        }
    }
}
