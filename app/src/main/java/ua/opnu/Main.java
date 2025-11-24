package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println(middleName.isPresent());
        System.out.println(middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println(username.isPresent());
        System.out.println(username.get());
        System.out.println(username.orElse("guest"));

        try {
            middleName.get();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            new MyOptional<>(null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        BookData b1 = new BookData("Java Basic", "Author A", 10, 50.0);
        BookData b2 = new BookData("Java Advanced", "Author B", 5, 20.0);
        BookData b3 = new BookData("Python Intro", "Author C", 10, 50.0);

        System.out.println(b1.compareTo(b2));
        System.out.println(b1.compareTo(b3));

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        String[] words = {"apple", "banana", "cherry", "date"};
        Predicate<String> lengthFilter = s -> s.length() > 5;
        String[] longWords = FilterUtil.filter(words, lengthFilter);
        System.out.println(Arrays.toString(longWords));

        Integer[] numbers = {10, 20, 30, 40};
        System.out.println(SearchUtil.contains(numbers, 20));
        System.out.println(SearchUtil.contains(numbers, 99));

        GenericTwoTuple<String, Integer> studentScore = new GenericTwoTuple<>("Ivan", 95);
        System.out.println(studentScore);

        GenericThreeTuple<String, Integer, Boolean> fullStudentInfo = new GenericThreeTuple<>("Ivan", 95, true);
        System.out.println(fullStudentInfo);
    }
}