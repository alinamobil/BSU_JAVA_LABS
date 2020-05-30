package by.bsu.study.lab9.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class Text {
    private static Logger log = LogManager.getLogger(Text.class.getSimpleName());
    private ArrayList<Sentence> sentences;

    public Text(String textPath) throws IOException {
        File file = new File(textPath);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        StringBuilder builder = new StringBuilder();

        String line = "";
        while (line != null) {
            builder.append(line);
            line = reader.readLine();
            builder.append(" ");
        }

        sentences = new ArrayList<Sentence>();

        String[] fileText = builder.toString().trim().split("[.]");
        for (String sentence: fileText){
            sentences.add(new Sentence(sentence.trim()));
        }
    }

    public ArrayList<Sentence> getSentences() {
        return new ArrayList<>(sentences);
    }
    public Sentence getSentence(int index){
        return sentences.get(index);
    }
    public void setSentence(int index, Sentence sentence){
        sentences.set(index, sentence);
    }
    public void removeSentence(int index){
        sentences.remove(index);
    }
    public int getSize(){
        return sentences.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Sentence sentence: sentences){
            builder.append(sentence.toString()).append(". ");
        }
        return builder.toString();
    }
}
