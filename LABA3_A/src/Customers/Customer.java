package Customers;

public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int card;
    private int bill;
    Customer() {
    }

    Customer(int id, String surname, String name, String patronymic, String address, int card, int bill) { //конструкторы
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.card = card;
        this.bill = bill;
    }

    public String getSurname() {
        return this.surname;
    } //метод Get и конструкторы

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCard() {
        return this.card;
    }

    public void setCard(int card) {this.card = card; }

    public String toString() {
        return "№ в списке: " + this.id + ": " + this.surname + " " + this.name + " " + this.patronymic + ", адрес: " + this.address  + ", номер карты: " + this.card + ", номер счета: " + this.bill + ".";
    }
}

