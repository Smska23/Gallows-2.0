import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String game_control_str; // для ввода любого символа
    static Integer game_control;  // для перевода введенного в Integer
    static boolean start = false;
    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            do {
                Game.gameIsOver = false;
                Game.gameWin = false;
                System.out.println("1 - начало игры");
                System.out.println("2 - выход");
                check();
            } while (start == false);

        }
    }
    public static void check() throws FileNotFoundException {    // проверка введенного символа
        boolean format = false;
        do {
            do {
                try {
                    game_control_str = sc.nextLine();
                    game_control = Integer.parseInt(game_control_str);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода!(введите 1 или 2)");
                    game_control_str = null;
                    game_control = null;
                }
                if (game_control != null) {
                    format = true;
                }
            } while (format == false);


            if (game_control == 1) {
                System.out.println("Начало игры");
                format = false;
                start = true;
                RandomWordChoice.LoadingDictionary();
                Game.start();
            } else if (game_control == 2) {
                System.out.println("Конец игры");
                System.exit(1);
            } else {
                System.out.println("Некоректная команда, попробуйте снова!");
                format = false;
                game_control = null;
            }
        }while(start == false);
    }
}
