package com.flowers;

public class Lily extends com.flowers.Flower { //класс цветка "Лилия" наследуется от класса Цветы
    final String name = "Лилия";

    public String getName()
    {
        return name;
    }

    public Lily() { }

    public Lily(double price, double steamlength, int dayoffreshness, String name) {
        super(price,steamlength,dayoffreshness,name);
    }
}
