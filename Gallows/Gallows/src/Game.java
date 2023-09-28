import java.util.Arrays;
import java.util.Scanner;
public class Game {
    static int errors = 0; // контроль ошибок
    static boolean gameIsOver = false; // контроль конца игры
    static char character;
    static boolean gameWin = false;


    public static void start(){
        Scanner sc = new Scanner(System.in);
        do{
            Symbols.gallows();
            System.out.print("Загаданное слово: ");
            for(int i = 0; i < RandomWordChoice.closedWord.length; i ++){
                System.out.print(RandomWordChoice.closedWord[i]);
            }
            System.out.println("");
            System.out.println("Количество ошибок: " + errors);
            if(errors < 6){
                System.out.print("Введите букву: ");
                character = sc.next().charAt(0);
                LetterVerification.verification();
            } else if (errors == 6){
                System.out.println("");
                System.out.println("Вы проиграли!");
                System.out.println("Загаданное слово: " + RandomWordChoice.controlWord);
                System.out.println("");
                errors = 0;
                gameIsOver = true;
            }
            if(Arrays.equals(RandomWordChoice.closedWord,RandomWordChoice.copyOfMainWord) == true){
                gameWin = true;
            }
            if(gameWin == true){
                System.out.println("");
                System.out.println("Вы победили!");
                System.out.println("Загаданное слово: " + RandomWordChoice.controlWord);
                System.out.println("");
                errors = 0;
                gameIsOver = true;
            }
        }while(gameIsOver == false);
    }
}
