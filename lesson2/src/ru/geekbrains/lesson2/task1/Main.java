package ru.geekbrains.lesson2.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("MyLinkedList created:");
        print(list);

        System.out.println("\nMyLinkedList added:");
        list.add("String-1");
        list.add("String-2");
        list.add("String-3");
        list.add("String-4");
        list.add("String-5");
        print(list);

        System.out.println("\nMyLinkedList changed:");
        list.set(2, "New-String-1");
        print(list);

        System.out.println("\nMyLinkedList removed:");
        list.remove("New-String-1");
        print(list);

        System.out.println("\nMyLinkedList autogrow:");
        MyLinkedList<Integer> mylist = new MyLinkedList<>();
        for (int i = 0; i < 15; i++) {
            mylist.add(i + 1);
        }
        print(mylist);
    }

    public static void print(MyLinkedList list) {
        System.out.println("Size: " + list.size());
        System.out.println("Elements: " + Arrays.toString(list.toArray()));
    }
}
