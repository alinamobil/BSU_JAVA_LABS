package text;

import java.util.Scanner;

public class Word {
    public String value = "";//переменная для хранения слова
    private byte[] bytes;

    public Word(String value) {
        this.value = value;
    }
    public Word() { }

    public void input() {  // ввод слова
        Scanner inp = new Scanner( System.in );
        System.out.println("Введите слово: ");
        value = inp.next();
    }
    public String getValue() {
        return value;
    }

    @Override
    //getClass() – возвращает ссылку на метаобъект типа класс(получаем инфу о классе, к которому принадлежит объект)
    public boolean equals(Object o) {  //метод equals для слов
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Word word = (Word) o;
        return value == word.value;
    }

    @Override
    public int hashCode() {  //метод hashCode для слов
        int result = 1;
        return result = 31 * result + ((value == null) ? 0 : value.hashCode());
    }

    @Override
    public String toString() {  //метод toString для слов
        return "Слово: " + value;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}

