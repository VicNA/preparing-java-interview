package ru.geekbrains.lesson2.task2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        System.out.println("MyArrayList created:");
        print(list);

        System.out.println("\nMyArrayList added:");
        list.add("String-1");
        list.add("String-2");
        list.add("String-3");
        list.add("String-4");
        list.add("String-5");
        print(list);

        System.out.println("\nMyArrayList changed:");
        list.set(2, "New-String-1");
        print(list);

        System.out.println("\nMyArrayList removed:");
        list.remove("New-String-1");
        print(list);

        System.out.println("\nMyArrayList autogrow:");
        MyArrayList<Integer> mylist = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            mylist.add(i + 1);
        }
        print(mylist);
    }

    public static void print(MyArrayList list) {
        System.out.println("Size: " + list.size());
        System.out.println("Elements: " + Arrays.toString(list.toArray()));
    }
}
