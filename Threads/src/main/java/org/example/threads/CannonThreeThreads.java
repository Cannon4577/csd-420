package org.example.threads;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

//Cannon Rivera
//2/15/2026
//CSD420-T301 Advanced Java Programming
//The Purpose of this program is to print out 10,000 numbers, letters, and symbols
//in a text area using threads.

public class CannonThreeThreads extends Application {

    private static final int AMOUNT = 10_000;
    private static final char[] SYMBOLS = {'!', '@', '#', '$', '%', '&', '*'};

    private TextArea output;

    private int lettersCount = 0;
    private int numbersCount = 0;
    private int symbolsCount = 0;

    @Override
    public void start(Stage stage) {
        output = new TextArea();
        output.setWrapText(true);

        Button start = new Button("Start");
        start.setOnAction(e -> runThreads());

        VBox root = new VBox(10, start, output);

        stage.setTitle("Three Threads");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    private void runThreads() {
        output.clear();
        lettersCount = 0;
        numbersCount = 0;
        symbolsCount = 0;

        Thread thread1 = new Thread(() -> {
            String letters = randomLetters(AMOUNT);
            lettersCount = letters.length();
            Platform.runLater(() ->
                    output.appendText("Letters:\n" + letters + "\n\n"));
        });

        Thread thread2 = new Thread(() -> {
            String numbers = randomNumbers(AMOUNT);
            numbersCount = numbers.length();
            Platform.runLater(() ->
                    output.appendText("Digits:\n" + numbers + "\n\n"));
        });

        Thread thread3 = new Thread(() -> {
            String symbols = randomSymbols(AMOUNT);
            symbolsCount = symbols.length();
            Platform.runLater(() ->
                    output.appendText("Symbols:\n" + symbols + "\n\n"));
        });

        thread1.start();
        thread2.start();
        thread3.start();

        new Thread(() -> {
            try {
                thread1.join();
                thread2.join();
                thread3.join();

                runTests();

                Platform.runLater(() -> {
                    output.appendText("Letters: " + lettersCount + "\n");
                    output.appendText("Numbers : " + numbersCount + "\n");
                    output.appendText("Symbols: " + symbolsCount + "\n");
                    output.appendText("All tests PASSED\n");
                });
            } catch (RuntimeException | InterruptedException e) {
                Platform.runLater(() ->
                        output.appendText("TEST FAILED: " + e.getMessage() + "\n"));
            }
        }).start();
    }


    private static String randomLetters(int amount) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(amount);
        for (int i = 0; i < amount; i++) {
            sb.append((char) ('a' + r.nextInt(26)));
        }
        return sb.toString();
    }

    private static String randomNumbers(int amount) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(amount);
        for (int i = 0; i < amount; i++) {
            sb.append((char) ('0' + r.nextInt(10)));
        }
        return sb.toString();
    }

    private static String randomSymbols(int amount) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(amount);
        for (int i = 0; i < amount; i++) {
            sb.append(SYMBOLS[r.nextInt(SYMBOLS.length)]);
        }
        return sb.toString();
    }

    private void runTests() {
        if (lettersCount < AMOUNT) throw new RuntimeException("Letters did not print 10,000");
        if (numbersCount < AMOUNT) throw new RuntimeException("Numbers did not print 10,000");
        if (symbolsCount < AMOUNT) throw new RuntimeException("Symbols did not print 10,000");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
