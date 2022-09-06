//package ru.geekbrains.lesson1.task2;
//
//interface Moveable {
//    void move();
//}
//interface Stopable {
//    void stop();
//}
//
//abstract class Car {
//    public Engine engine;
//    private String color;
//    private String name;
//    protected void start() {
//        System.out.println("Car starting");
//    }
//    abstract void open();
//    public Engine getEngine() {
//        return engine;
//    }
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//    public String getColor() {
//        return color;
//    }
//    public void setColor(String color) {
//        this.color = color;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//class LightWeightCar extends Car implements Moveable {
//    @Override
//    void open() {
//        System.out.println("Car is open");
//    }
//    @Override
//    public void move() {
//        System.out.println("Car is moving");
//    }
//}
//class Lorry extends Car, Moveable, Stopable {
//    public void move(){
//        System.out.println("Car is moving");
//    }
//    public void stop(){
//        System.out.println("Car is stop");
//    }
//}

// Ошибки:
// 1) Отсутствует класс Engine
// 2) В классе Lorry не реализован метод open() из абстрактного класса Car
// Оптимизация:
// 1) Имплементить интерфейсы Moveable, Stopable в абстрактном классе Car
// 2) Можно вывести методы start(), open() класса Car в отдельные интерфейсы и имплементировать в классе Car