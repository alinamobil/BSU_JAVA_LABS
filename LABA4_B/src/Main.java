//Создать консольное приложение, удовлетворяющее следующим требованиям:
// • Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
// • Каждый класс должен иметь отражающее смысл название и информативный состав.
// • Наследование должно применяться только тогда, когда это имеет смысл.
// • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
// • Классы должны быть грамотно разложены по пакетам. • Консольное меню должно быть минимальным.
// • Для хранения параметров инициализации можно использовать файлы.
// Цветочница. Определить иерархию цветов. Создать несколько объектов-цветов.
// Собрать букет (используя аксессуары) с определением его стоимости.
// Провести сортировку цветов в букете на основе уровня свежести.
// Найти цветок в букете, соответствующий заданному диапазону длин стеблей.

package com.florist;
import com.flowers.Flower;
import com.flowers.Rose;
import com.exception.AccessoryLogicException;
import com.exception.FlowerLogicException;
import java.util.Scanner;
import com.serializator.Serializator;
import java.io.InvalidObjectException;

public class Main {

    public static void main(String[] args) throws FlowerLogicException, AccessoryLogicException {
        com.florist.Bouquet bouquet = new com.florist.Bouquet();
        Menu(bouquet);
    }

    private static void Menu(com.florist.Bouquet ob) throws  FlowerLogicException, AccessoryLogicException {

        boolean f = true;
        while(true) {
            System.out.println("1.Создать букет и узнать его стоимость");
            System.out.println("2.Сортировать цветы в букете по свежести");
            System.out.println("3.Найти цветок, соотвествующий заданному диапозону длин стеблей");
            System.out.println("4.Процесс сериализации");
            System.out.println("5.Выйти из программы");

            System.out.println("Введите пункт: ");
            Scanner conin = new Scanner(System.in);
            int tasknum;
            tasknum = conin.nextInt();

            switch (tasknum) {
                case 1 :
                    ob.chooseFlower();
                    ob.chooseAccessory();
                    System.out.println("Итого: ");
                    ob.printBouquet();
                    System.out.println();
                    break;
                case 2 :
                    ob.sortFlowers();
                    System.out.println();
                    break;
                case 3 :
                    int num1 = 0, num2 = 0;
                    System.out.println("Введите диапазоны длин стебля: ");
                    num1 = conin.nextInt();
                    num2 = conin.nextInt();
                    ob.findFlowers(num1, num2);
                    System.out.println();
                    break;
                case 4 :
                    System.out.println(ob);
                    String file = "E:/proga_4_sem/laba-4.1b/data.text";
                    Serializator sz = new Serializator();
                    boolean b = sz.serializationBouquet(ob, file);
                    com.florist.Bouquet res = null;
                    try {
                        res = sz.deserializationBouquet(file);
                    } catch (InvalidObjectException e) {

                        e.printStackTrace();
                    }
                    System.out.println(res);
                    break;
                case 5:
                    f = false;
                    return;
            }
        }
    }
}
