package text;

import java.io.*;

public class Text extends text.Sentence {
    private String header;  //переменная для заголовка
    public Text() { }
    public Text(text.Word word) {
        header = word.getValue();
    }
    /*public Text(Sentence sent) {
        header = sent.getValue();
    }*/
    public String getHeader() {
        return header;
    }

    public void addValue(text.Sentence sent) {  //добавляем предложение в текст
        value += " " + sent.getValue();
    }

    public void readText(String file){ //чтение текста из файла
        File f = new File(file);
        int b, count = 0;
        FileReader is = null;
        try {
            is = new FileReader(f);
            while((b = is.read()) != -1) {
                System.out.print((char)b);
                count++;
            }
            System.out.print("Число байт : " + count);

        }catch (IOException e) {
            System.out.println("Ошибка");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия: " + e);
            }
        }
    }

    public String getBody() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  //метод equals для текста
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Text text = (Text) o;
        return value == text.value;
    }

    @Override
    public int hashCode() {   //метод hashCode для текста
        int result = 1;
        return result = 31 * result + ((value == null) ? 0 : value.hashCode());
    }

    @Override
    public String toString() {  //метод toString для текста
        return "Текст: " + value;
    }
}

