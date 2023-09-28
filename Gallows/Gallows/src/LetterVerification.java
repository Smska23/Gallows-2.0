public class LetterVerification {
    static boolean test = false;

    public static void verification() {
            for (int y = 0; y < RandomWordChoice.closedWord.length; y++) {       //проверка соответсвий
                if (Character.toLowerCase(Game.character) == RandomWordChoice.result[y]) {
                    RandomWordChoice.closedWord[y] = String.valueOf(Character.toLowerCase(Game.character));
                    test = true;
                }
            }

            if (test == false) {
                Game.errors++;
            } else if (test == true) {
                System.out.println("");
                System.out.println("Вы отгадали!");
                System.out.println(" ");
                test = false;
            }
    }
}
