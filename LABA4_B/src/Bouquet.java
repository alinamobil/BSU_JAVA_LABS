package com.florist;
import com.accessories.*;
import com.exception.AccessoryLogicException;
import com.exception.FlowerLogicException;
import com.flowers.Flower;
import com.flowers.Rose;
import com.flowers.Peony;
import com.flowers.Lily;
import com.flowers.Chrysanthemum;
import com.flowers.Chamomile;
import com.serializator.Serializator;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.*;

public class Bouquet implements Serializable{  //класс Букет реализует интерфейс Serializable
    //Serializable - интерфейс-маркер,в нём не задекларировано ни одного метода.
    //Сообщает сериализующему механизму, что класс может быть сериализован.
    private double totalPrice = 0;  //стоимость букета(с цветами и аксессуарами)
    private ArrayList<Flower> objectArray = new ArrayList<>(); //массив для цветов букета
    private ArrayList<com.accessories.Accessory> objectArrayAcc = new ArrayList<>();  //массив для аксессуаров букета

    @Override
    public String toString() { //описание букета
        return "\nСтоимость букета: " + totalPrice + "\nЦветы:" + objectArray+"\nАксессуары:"+ objectArrayAcc;
    }

    public void chooseFlower() throws FlowerLogicException { //функция выбора цветов
        Scanner in = new Scanner(System.in);
        int amount = 0, flower = 0;
        System.out.println("Введите количество цветов: ");
        amount = in.nextInt();
        for(int i = 0; i < amount; i++) {
            System.out.println("Выберите цветы : ");
            System.out.println("1.Роза");
            System.out.println("2.Ромашка");
            System.out.println("3.Хризантема");
            System.out.println("4.Лилия");
            System.out.println("5.Пион");
            flower = in.nextInt();
            switch (flower)  {
                case 1 :
                    Rose rose = new Rose();
                    inputData(rose);
                    addFlowerToBouquet(rose);
                    //flowerToFile(rose);
                    break;
                case 2 :
                    Chamomile cham = new Chamomile();
                    inputData(cham);
                    addFlowerToBouquet(cham);
                    //flowerToFile(cham);
                    break;
                case 3 :
                    Chrysanthemum chrys = new Chrysanthemum();
                    inputData(chrys);
                    addFlowerToBouquet(chrys);
                    //flowerToFile(chrys);
                    break;
                case 4 :
                    Lily lil = new Lily();
                    inputData(lil);
                    addFlowerToBouquet(lil);
                    //flowerToFile(lil);
                    break;
                case 5:
                    Peony peony = new Peony();
                    inputData(peony);
                    addFlowerToBouquet(peony);
                    //flowerToFile(peony);
                    break;
                default: break;
            }
        }
    }

    public void chooseAccessory() throws AccessoryLogicException { //функция выбора Аксессуара
        Scanner in = new Scanner(System.in);
        int amount = 0, acc = 0;
        System.out.println("Введите количество аксесуаров: ");
        amount = in.nextInt();
        for (int i = 0; i < amount; i++) {
            System.out.println("Выберите аксессуар: ");
            System.out.println("1.Целофановая упаковка");
            System.out.println("2.Плотная упаковка");
            System.out.println("3.Бантик");
            System.out.println("4.Атласная лента");
            acc = in.nextInt();
            switch (acc) {
                case 1:
                    com.accessories.Cellophane cell = new com.accessories.Cellophane();
                    inputDataAcc(cell);
                    addAccessoryToBouquet(cell);
                    //accessoryToFile(cell);
                    break;
                case 2:
                    com.accessories.Kraftpaper kraftpaper = new com.accessories.Kraftpaper();
                    inputDataAcc(kraftpaper);
                    addAccessoryToBouquet(kraftpaper);
                    //accessoryToFile(kraftpaper);
                    break;
                case 3:
                    com.accessories.Bow b = new com.accessories.Bow();
                    inputDataAcc(b);
                    addAccessoryToBouquet(b);
                    //accessoryToFile(b);
                    break;
                case 4:
                    com.accessories.Satintape tape = new com.accessories.Satintape();
                    inputDataAcc(tape);
                    addAccessoryToBouquet(tape);
                    //accessoryToFile(tape);
                    break;
            }
        }
    }


    private static void inputData(Flower fl) throws FlowerLogicException { //ввод данных о цветке
        Scanner in = new Scanner(System.in);
        double price, stemlength; //цена, длина стебля
        int dayoffreshness = 0; //день свежести
        System.out.println("Введите цену: ");
        price = in.nextInt();
        fl.setPrice(price);
        System.out.println("Введите длину стебля: ");
        stemlength = in.nextInt();
        fl.setStemlength(stemlength);
        System.out.println("Введите день свежести: ");
        boolean f = true;
        while(f){
            try{
                String str = in.nextLine();
                dayoffreshness = Integer.parseInt(str);
                f = false;
                break;
            } catch (Exception ignore){
            }
        }
        //      break one;
        // } catch (Exception ignored) {

        //}
        //}
        fl.setDayoffreshness(dayoffreshness);
    }

    private void inputDataAcc(com.accessories.Accessory acc) throws AccessoryLogicException{ //ввод данных о аксессуаре
        Scanner in = new Scanner(System.in);
        double price; //цена
        System.out.println("Введите цену: ");
        price = in.nextInt();
        acc.setPrice(price);
    }

    private void addFlowerToBouquet(Flower object) { //добавляем цветок в букет
        objectArray.add(object);
    } //инкапсуляция. Когда коды и данные объединяются таким способом, создаётся объект (object). Другими словами, объект - это то, что поддерживает инкапсуляцию.

    private void addAccessoryToBouquet(com.accessories.Accessory objectacc) { //добавляем аксессуар в букет
        objectArrayAcc.add(objectacc);
    }

    private void setTotalPrice(double price) {  //устанавливаем стоимость букета
        totalPrice = price;
    }

    void printBouquet(){  //функция расчёта стоимости букета
        double total = 0; //стоимость вся
        double currentTotalPriceFlower = 0; //текущая цена цветов
        double currentTotalPriceAcc = 0; //текущая цена аксессуаров
        for (int i = 0; i < objectArray.size(); i++) { //считаем стоимость цветов
            Flower object = objectArray.get(i);
            String name = object.getName();
            double price = object.getPrice();
            System.out.println(name + " \t " + price);
            currentTotalPriceFlower += price;
        }

        for (com.accessories.Accessory objectacc : objectArrayAcc) {//считаем стоимость аксессуаров
            String name = objectacc.getName();
            double priceacc = objectacc.getPrice();
            System.out.println(name + " \t " + priceacc);
            currentTotalPriceAcc += priceacc;
        }

        total = currentTotalPriceAcc + currentTotalPriceFlower; //считаем общую стоимость букета
        setTotalPrice(total);
        System.out.println("Цена \t " + total);
    }

    public void sortFlowers() { //функция сортировки цветов
        Collections.sort(objectArray);
        for (int i = 0; i < objectArray.size(); i++) {
            Flower object = objectArray.get(i);
            String name = object.getName();
            System.out.println((i+1)+")"+name);
        }
    }

    public void findFlowers(double length1, double length2) {  //функция нахождения цветок в букете по длине стебля
        for (Flower object : objectArray) {
            double stemlength = object.getStemlength();
            String name = object.getName();
            if (stemlength > length1 && stemlength < length2)
                System.out.println(name + " " + stemlength);
        }
    }

    private void flowerToFile(Flower ob) { //запись цветов в файл
        System.out.println(ob);
        String file = "E:/proga_4_sem/laba-4.1b/dataflower.text";
        Serializator sz = new Serializator();
        boolean b = sz.serializationFlower(ob, file);
        Flower res = null;
        try {
            res = sz.deserializationFlower(file);
        } catch (InvalidObjectException e) {

            e.printStackTrace();
        }
        System.out.println(res);
    }
    private void accessoryToFile(com.accessories.Accessory ac) { //запись аксессуаров в файл
        System.out.println(ac);
        String file = "E:/proga_4_sem/laba-4.1b/dataaccessory.text";
        Serializator sz = new Serializator();
        boolean b = sz.serializationAccessory(ac, file);
        com.accessories.Accessory res = null;
        try {
            res = sz.deserializationAccessory(file);
        } catch (InvalidObjectException e) {

            e.printStackTrace();
        }
        System.out.println(res);
    }
}



