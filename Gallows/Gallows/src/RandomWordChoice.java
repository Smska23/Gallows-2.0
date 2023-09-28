import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomWordChoice {
    public static String[] closedWord;
     public static List<String> words = new ArrayList<>();
     public static String controlWord;
     static char[] result;
     public static String[] copyOfMainWord;
    public static List<String> LoadingDictionary() throws FileNotFoundException{
        // создание списка из файла
        String fileName = "russian_nouns.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        foundControlWord();
        return words;
    }
        // выбор рандомного слова
    public static String foundControlWord(){
        int n = (int) (Math.random() * 12);
        controlWord = words.get(n);
        checkCharacter();
        closed();
        return controlWord;
    }
        // создание вспомогательных массивов

    public static void checkCharacter() {
        result = controlWord.toCharArray();  // массив чар для проверки введённой буквы
        copyOfMainWord = new String[result.length];
        for(int i = 0; i < copyOfMainWord.length; i++){
            copyOfMainWord[i] = String.valueOf(result[i]);
        }
    }

    public static void closed(){
        closedWord = new String[result.length]; // стринг массив для вывода звездочек
        for (int i = 0; i < closedWord.length; i++) {    // заполняем буквами по мере продвижения
            closedWord[i] = "*";
        }



    }
}
