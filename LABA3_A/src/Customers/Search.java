package Customers;

import java.util.*;

import Customers.Customer;

public class Search {
    private ArrayList<Customer> CustomerList = new ArrayList();

    Search(String Name) {
    }

    void addCustomerToCustomerList(Customer cust) {
        this.CustomerList.add(cust);
    }

    List<Customer> searchSurname() {
        List<Customer> list = new ArrayList<>(CustomerList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getSurname().compareToIgnoreCase(o2.getSurname());
            }

        });
        return list;
    }

    List<Customer> searchCard() {
        Scanner in = new Scanner(System.in);
        List<Customer> list = new ArrayList();
        System.out.println("Введите начало интервала: ");
        int begin = in.nextInt();
        System.out.println("Введите конец интервала: ");
        int end = in.nextInt();
        System.out.println();
        System.out.println("Покупатели: ");
        Iterator var4 = this.CustomerList.iterator();

        while (var4.hasNext()) {
            Customer i = (Customer) var4.next();
            if ((i.getCard() >= begin) && (i.getCard() <= end)) {
                list.add(i);
            }
        }
        return list;
    }}

