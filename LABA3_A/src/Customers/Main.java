package Customers;
/*Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
Создать массив объектов. Вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится
в заданном интервале.*/

import Customers.Search;
import Customers.Customer;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    private static void selection(int p, Search CustomerList) {
        switch(p) {
            case 1: //алфавитный порядок
                List<Customer> searchSurname = CustomerList.searchSurname();

                for (Object a : searchSurname) {
                    System.out.println(a);
                }

                System.out.println();
                break;
            case 2: //банковские карты в диапазоне
                List<Customer> searchCard = CustomerList.searchCard();
                Iterator var10 = searchCard.iterator();

                while(var10.hasNext()) {
                    Customer b = (Customer)var10.next();
                    System.out.println(b);
                }

                System.out.println();
                break;
            case 3://выход
                System.exit(0);
        }

    }

    public static void main(String[] args) {//формируем список
        Search List = new Search("CustomerList");
        List.addCustomerToCustomerList(new Customer(1, "Чикова", "Екатерина ", "Вадимовна", "ул.Октябрьская,4/2", 1, 11));
        List.addCustomerToCustomerList(new Customer(2, "Булгак", "Виктория", "Васильевна", "ул.Петра Глебки,18", 10, 22));
        List.addCustomerToCustomerList(new Customer(3, "Васильев", "Андрей", "Петрович", "ул.Энгельса,26", 100, 33));
        List.addCustomerToCustomerList(new Customer(4, "Карпенко", "Алексей", "Игоревич", "пр.Свободы,172", 5, 44));
        List.addCustomerToCustomerList(new Customer(5, "Денисова", "Татьяна", "Михайловна", "ул.К Маркса,13", 50, 55));
        List.addCustomerToCustomerList(new Customer(6, "Енко", "Татьяна", "Всеволодовна", "ул.Сулистровского,7", 500, 66));

        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Выберите необходимый пункт:");
            System.out.println("1. Вывод всех покупателей в алфавитном порядке");
            System.out.println("2. Вывод покупателей с номером карты в диапазоне");
            System.out.println("3. Выход");
            System.out.println("Ваш выбор: ");
            int p = in.nextInt();
            selection(p, List);
        }

    }
}
