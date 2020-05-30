package var2;

import base.Punctuation;
import base.Text;
import base.Sentence;
import base.Word;

import java.io.IOException;
import java.util.*;

public class WordsInSentencesMain {

    public static void partB() {
        String text = "Мама, папа, я -  семья. \n" +
                "Мама, папа, я - дружная семья.\n" +
                "Мама, папа, я.\n" +
                "Мама, папа.\n" +
                "Я.\n";

        System.out.println("Текст:\n" + text);

        Sentence[] sentences = Sentence.toSentencesArray(text);

        Arrays.sort(sentences, Collections.reverseOrder());
        System.out.println("\nОтсортированный текст:");
        for (Sentence s : sentences) {
            System.out.println(s);
        }
    }

    public static void partC() {
        String text = "Мама, папа, я - дружная семья.\n";

        int maxDistance = -1;
        char maxSymbol = '!';

        for (char symbol = 'а'; symbol <= 'я'; symbol++) {
            int firstIndex = text.toLowerCase().indexOf(symbol);
            int lastIndex = text.toLowerCase().lastIndexOf(symbol);

            int distance = lastIndex - firstIndex;
            if (distance > 0) {
                System.out.println("Количество символов между буквами " +String.valueOf(symbol) + " - " + distance);
            }

            if (distance > maxDistance) {
                maxDistance = distance;
                maxSymbol = symbol;
            }
        }

        System.out.println("Максимальная величина: " + String.valueOf(maxSymbol) + " - " + maxDistance);

        int maxIndex = text.toLowerCase().indexOf(maxSymbol);
        text = text.replace(text.substring(maxIndex, maxIndex + maxDistance + 1), "");

        System.out.println(text);

    }

    public static void main(String[] args) {

      //partB();
      partC();
    }
}