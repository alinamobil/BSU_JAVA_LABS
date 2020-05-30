package com.flowers;

public class Chamomile extends com.flowers.Flower { //класс цветка "Ромашка" наследуется от класса Цветы
    final String name = "Ромашка";

    public String getName() {
        return name;
    }

    public Chamomile() { }

    public Chamomile(double price, double steamlength, int dayoffreshness,String name) {
        super(price,steamlength,dayoffreshness,name);
    }
}
