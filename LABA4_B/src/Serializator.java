package com.serializator;
import com.accessories.Accessory;
import com.florist.Bouquet;
import com.flowers.Flower;
import java.io.NotSerializableException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.FileNotFoundException;

public class Serializator {
    //сериализация - запись состояния объекта в поток
    public boolean serializationFlower(Flower s, String fileName) {//сериализация для класса Цветы
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ostream = new ObjectOutputStream(fos);
            ostream.writeObject(s); // записывает в поток отдельный объект
            flag = true;
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: "+ e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close(); //закрыли поток
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока!");
            }
        }
        return flag;
    }

    public Flower deserializationFlower(String fileName) throws InvalidObjectException {  //десериализация для класса Цветы
        // десериализация-извлечение или восстановление состояния объекта из потока
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);

            return (Flower) istream.readObject(); //считывает из потока объект
        } catch (ClassNotFoundException ce) {

            System.err.println("Класс не существует: " + ce);
        } catch (FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: "+ e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally {
            try {
                if (istream != null) {
                    istream.close();  //закрыли поток
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока! ");
            }
        }
        throw new InvalidObjectException("Объект не восстановлен!");
    }
    public boolean serializationAccessory(Accessory s, String fileName) { //сериализация для класса Аксессуары
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ostream = new ObjectOutputStream(fos);
            ostream.writeObject(s);
            flag = true;
            System.out.println("Процесс прошел успешно");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: "+ e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока!");
            }
        }
        return flag;
    }

    public Accessory deserializationAccessory(String fileName) throws InvalidObjectException { //десериализация для класса Аксессуары
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            return (Accessory) istream.readObject();
        } catch (ClassNotFoundException ce) {

            System.err.println("Класс не существует: " + ce);
        } catch (FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: "+ e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока! ");
            }
        }
        throw new InvalidObjectException("Объект не восстановлен");
    }

    public boolean serializationBouquet(Bouquet s, String fileName) { //сериализация для класса Букет
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ostream = new ObjectOutputStream(fos);
            ostream.writeObject(s); // сериализация
            flag = true;
            System.out.println("Процесс прошел успешно");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: "+ e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока!");
            }
        }
        return flag;
    }

    public Bouquet deserializationBouquet(String fileName) throws InvalidObjectException { //десериализация для класса Букет
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            return (Bouquet) istream.readObject();
        } catch (ClassNotFoundException ce) {

            System.err.println("Класс не существует: " + ce);
        } catch (FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: "+ e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая I/O ошибка: " + ioe);
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока! ");
            }
        }
        throw new InvalidObjectException("Объект не восстановлен!");
    }
}
