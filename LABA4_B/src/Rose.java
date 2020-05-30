package com.flowers;

public class Rose extends com.flowers.Flower {  //класс цветка "Роза" наследуется от класса Цветы
    final String name = "Роза";

    public String getName() {
        return name;
    }

    public Rose() { }
    public Rose(double price, double steamlength, int dayoffreshness,String name) {
        super(price,steamlength,dayoffreshness,name);
    }
}
