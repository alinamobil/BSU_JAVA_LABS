package com.flowers;

public class Peony extends com.flowers.Flower { //класс цветка "Пионы" наследуется от класса Цветы
    final String name = "Пионы";

    public String getName() {
        return name;
    }

    public Peony() { }

    public Peony(double price, double steamlength, int dayoffreshness,String name) {
        super(price,steamlength,dayoffreshness,name);
    }
}
