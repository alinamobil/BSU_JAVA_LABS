
package base;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Text {

    private final static EnumSet<Punctuation> sentencePunctuation = EnumSet.range(Punctuation.EXCLAMATION, Punctuation.DISAMBIGUATION);
    final static EnumSet<Punctuation> allPunctuation = EnumSet.allOf(Punctuation.class);
    private String fileAddress;
    private String wholeText;
    private List<Sentence> sentences;

    public Text(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    private String getWholeText() {
        return wholeText;
    }

    public void createtext() throws IOException{ //чтение текста из файла
        try (BufferedReader reader = new BufferedReader(new FileReader(fileAddress))){
            StringBuilder wholeTextBuilder = new StringBuilder();
            while (reader.ready()) {
                String buffer = reader.readLine();
                buffer = buffer.replaceAll("\\s+", " ");
                wholeTextBuilder.append(buffer);
                wholeTextBuilder.append('\r');
            }
            wholeText = wholeTextBuilder.toString();
        }
    }

    public List<Sentence> getSentences(){ //формируем список предложений
        if (sentences != null) {
            return sentences;
        }
        else {
            sentences = new ArrayList<>();
            if (wholeText != null && wholeText.length() > 0) {
                int startPosition = 0;
                int index;
                for (index = startPosition; index < wholeText.length(); index++) {
                    for (Punctuation punctuation : Text.sentencePunctuation) {
                        if (wholeText.charAt(index) == punctuation.getSign()) {
                            if (startPosition < index) {
                                Sentence buffer = new Sentence(getWholeText().substring(startPosition, index));
                                sentences.add(buffer);
                            }
                            startPosition = index + 1;
                        }
                    }
                }
                if (startPosition < index) {
                    Sentence buffer = new Sentence(getWholeText().substring(startPosition, index));
                    sentences.add(buffer);
                }
            }
            return sentences;
        }
    }
}
