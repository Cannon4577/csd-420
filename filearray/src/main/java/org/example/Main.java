//Cannon Rivera FileArray 12/11/2025

//The Purpose of this program is to read from a file
//out to the user
package org.example;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
            File file = new File("file.dat");

            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            input.close();
    }
}