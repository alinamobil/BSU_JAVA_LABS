package main;

import text.Text;
import text.Word;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteToFile {
    public static void writeWords(Word data, String fileName) {
        File file = new File(fileName);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data.value);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeText(Text data, String fileName) {
        File file = new File(fileName);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data.value);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
