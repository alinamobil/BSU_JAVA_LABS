package base;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Sentence implements Comparable<Sentence> {
    public static final String SENTENCE_ENDS = ".!?";
    public static final String WORD_DELIMITERS = " \t\n\\,-_+*/@%#";

    private String text;
    private int words;

    public Sentence(String t) {
        text = t;
        words = (t.split("[" + WORD_DELIMITERS + SENTENCE_ENDS + "]")).length;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public int compareTo(Sentence another) {
        return another.words - words;
    }

    public static Sentence[] toSentencesArray(String input) {
        StringBuilder buf = new StringBuilder();
        List<Sentence> list = new LinkedList<Sentence>();

        for (char c : input.toCharArray()) {
            if (c == '\n')
                c = ' ';
            buf.append(c);
            if (SENTENCE_ENDS.indexOf(c) > -1) {
                list.add(new Sentence(buf.toString().trim()));
                buf = new StringBuilder();
            }
        }

        return list.toArray(new Sentence[list.size()]);
    }

}


