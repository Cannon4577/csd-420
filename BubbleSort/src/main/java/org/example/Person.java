package org.example;

public class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}
