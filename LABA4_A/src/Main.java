//Создать приложение, удовлетворяющее требованиям, приведенным в задании.
// Наследование применять только в тех заданиях, в которых это логически обосновано.
// Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(),
// hashCode(), toString().
// Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст, заголовок текста.


package main;
import text.Text;
import text.Sentence;
import text.Word;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Word head = new Word("Java"); //заголовка
        Text text = new Text(head);
        Word word1 = new Word("Лабораторная");
        Word word2 = new Word(" работа ");
        Word word3 = new Word(" выполнена ");
        Sentence phrase1 = new Sentence(); //предложение
        phrase1.addValue(word1);
        phrase1.addValue(word2);
        phrase1.addValue(word3);
        text.addValue(phrase1);
        System.out.println("Заголовок: "+text.getHeader());  //выводит заголовок
        System.out.println(text); //вывести текст

        //запись текста с консоли-дозаписать текст
        System.out.println("Дополнение текста.");
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Введите количество слов: ");
        n = in.nextInt();
        Word[] words = new Word[n];
        for (int i = 0; i < n; i++) {
            words[i] = new Word();
            words[i].input();
            System.out.println(words[i]);
        }
        Sentence sent1 = new Sentence();
        for(int i = 0; i < n; i++) {
            sent1.addValue(words[i]);
        }
        System.out.println(sent1);

        text.addValue(sent1);
        System.out.println("Дополненный текст: ");
        System.out.println(text); //вывести текст

        Text text1 = new Text();
        //text1.readText("D:/readFile.txt"); //вывести текст из файла

        //WriteToFile.writeWords(text1,"E:/proga_4_sem/laba-4.2a/writeFile.txt");//запись из одного в файла в другой
        // WriteToFile.writeWords(head,"E:/proga_4_sem/laba-4.2a/writeFile.txt"); //запись в файл заголовка
        main.WriteToFile.writeText(text,"E:/proga_4_sem/laba-4.2a/writeFile.txt");//запись в файл текста

    }
}

