package com.accessories;
import java.io.Serializable;
import com.exception.AccessoryLogicException;
import java.util.InputMismatchException;

public class Accessory implements Serializable { //класс Аксессуары реализует интерфейс Serializable
    //Serializable - интерфейс-маркер,в нём не задекларировано ни одного метода.
    //Сообщает сериализующему механизму, что класс может быть сериализован.
    private double price;  //цена аксессуара
    private String name; // название аксессуара

    public void setPrice(double price) throws AccessoryLogicException{  //устанавливаем цену и здесь обработчик исключения ввода цены
        try {
            if (price < 0) {
                throw new AccessoryLogicException("Цена должна быть положительной!");
            }
            this.price = price;
        }catch (InputMismatchException e) {
            System.out.println("Несоответсвие типов!");
        }
    }

    public double getPrice() {//получаем цену
        return price;
    }

    public String getName() { //получаем название
        return name;
    }

}

