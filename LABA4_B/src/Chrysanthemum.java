package com.flowers;

public class Chrysanthemum extends com.flowers.Flower {  //класс цветка "Хризантема" наследуется от класса Цветы
    final String name = "Хризантема";

    public String getName() {
        return name;
    }

    public Chrysanthemum() { }

    public Chrysanthemum(double price, double steamlength, int dayoffreshness,String name) {
        super(price,steamlength,dayoffreshness,name);
    }
}
