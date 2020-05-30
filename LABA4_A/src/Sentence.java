package text;

public class Sentence extends text.Word { //Класс Предложения наследуется от класса Слово

    public void addValue(text.Word word) {  //добавить слово в предложение
        value += " " + word.getValue();
    }

    public void addValue(text.Word[] word) {
        for(int i = 0; i < word.length; i++) {
            value += " " + word[i].getValue();
        }
    }

    @Override//переопределение
    public boolean equals(Object o) {  //метод equals для предложений
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sentence sent = (Sentence) o;
        return value == sent.value;
    }

    @Override
    public int hashCode() {  //метод hashCode для предложений
        int result = 1;
        return result = 31 * result + ((value == null) ? 0 : value.hashCode());
    }

    @Override
    public String toString() {  //метод toString для предложений
        return "Предложение: " + value;
    } //метод toString для предложений
}

