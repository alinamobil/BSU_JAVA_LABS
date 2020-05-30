package base;

public class Word {
    private String value;  //слово

    Word(String string) {
        value = string;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Word)){ //проверяем является ли объект "о" словом, если да то вернёт true
            return false;
        }
        Word word = (Word) o;

        if (!value.equals(word.value)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() { //возвращаем хеш-код слова
        return value.hashCode();
    }
}