import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static final String[] arr = {"Rock","Paper","Scissors"};
    public static int countTie = 0;
    public static int countWin = 0;
    public static int countLose = 0;

    public static String computerMove () {
        Random random = new Random();
        int randInt = random.nextInt(arr.length);
        String randomWord = arr[randInt];
        System.out.println(randomWord);
        return randomWord;
    }

    public static String playerMove() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter your move: ");
       String player = scanner.nextLine();
       while (true) {
          if (player.equalsIgnoreCase(arr[0]) || player.equalsIgnoreCase(arr[1]) || player.equalsIgnoreCase(arr[2])) {
              break;
          } else {
              System.out.println("Please try again");
              player = scanner.nextLine();
          }
      }
      return player;
    }

    public static void checkForWin() {
        String user = playerMove();
        String cpu = computerMove();
        if (user.equals(cpu)) {
            System.out.println("It is a tie!");
            countTie++;
        } else if ((user.equals(arr[0]) && cpu.equals(arr[2])) || (user.equals(arr[1]) && cpu.equals(arr[0]))
                || (user.equals(arr[2]) && cpu.equals(arr[1]))) {
            System.out.println("Congratulations! You won.");
            countWin++;
        } else {
            System.out.println("Sorry! You lost.");
            countLose++;
        }
    }

    public static void playingGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many rounds do you want to play?");
        try {
            int count = scan.nextInt();
            System.out.println(count);
            while (count > 0) {
                checkForWin();
                count--;
            }
            System.out.println("There are " + countTie + " tie(s)");
            System.out.println("You won " + countWin + " time(s)");
            System.out.println("You lost " + countLose + " time(s)");
        } catch (InputMismatchException ioe) {
            System.out.println("You don't deserve to play RockPaperScissors, if you are not able " +
                    "to put a positive integer");
        }

    }

    public static void main(String[] args) {
        playingGame();
    }
}
