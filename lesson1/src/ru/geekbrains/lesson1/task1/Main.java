package ru.geekbrains.lesson1.task1;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person.Builder().setFirstName("Viktor").setLastName("Nikolaev").build();
        Person person2 = new Person.Builder().setFirstName("Viktor").setMiddleName("Alekseevich").build();

        System.out.println(person1);
        System.out.println(person2);
    }
}
