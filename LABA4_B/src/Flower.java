package com.flowers;
import com.exception.FlowerLogicException;
import java.util.InputMismatchException;
import java.io.Serializable;
public class Flower implements Comparable<Flower>, Serializable{ //класс "Цветы" реализует интерфейсы Comparable<Flower> и Serializable
    //Интерфейс Comparable сравнивает текущий объект с объектом, переданным в качестве параметра в спец метод compareTo
    public static double price;  //цена
    private double stemlength;  //длина стебля
    private int dayoffreshness; //день свежести
    private String name;  //название

    Flower() { }

    Flower(double price, double stemlength, int dayoffreshness, String name) {
        Flower.price = price;
        this.stemlength = stemlength;
        this.dayoffreshness = dayoffreshness;
        this.name = name;
    }

    public String toString() {
        return "\nPrice: " + price +" p " +"\nLength of stem: " + stemlength + "\nDay of freshness: " + dayoffreshness;
    }

    public String getName() {
        return name;
    }


    public void setPrice(double price) throws FlowerLogicException { //устанавливаем цену и здесь обработчик исключения ввода цены
        try {
            if (price < 0) {
                throw new FlowerLogicException("Цена должна быть положительной!");
            }
            this.price = price;
        }catch (InputMismatchException e) {
            System.out.println("Несоответсвие типов!");
        }

    }

    public double getPrice() {
        return price;
    }

    public void setStemlength(double stemlength) throws FlowerLogicException { //устанавливаем длину стебля и здесь обработчик исключения ввода длины стебля
        try {
            if (price < 0) {
                throw new FlowerLogicException("Длина стебля должна быть положительной!");
            }
            this.stemlength = stemlength;
        }catch (InputMismatchException e) {
            System.out.println("Несоответсвие типов");
        }
    }

    public double getStemlength()  {
        return stemlength;
    }

    public void setDayoffreshness(int dayoffreshness) throws FlowerLogicException {  //устанавливаем день свежести и обработчик исключения ввода дня свежести
        try {
            if (price < 0) {
                throw new FlowerLogicException("День свежести должна быть положительной!");
            }
            this.dayoffreshness = dayoffreshness;
        } catch (InputMismatchException e) {
            System.out.println("Несоответсвие типов!");
        }
    }

    @Override
    public int compareTo(Flower fl) {
        return (this.dayoffreshness - fl.dayoffreshness);
    }

}
