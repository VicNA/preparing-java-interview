package ru.geekbrains.lesson1.task3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        List<Figure> list = Arrays.asList(circle, square, triangle);
        for (Figure figure : list) {
            figure.area();
        }
    }
}
