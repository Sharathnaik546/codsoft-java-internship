import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int roundsWon = 0;
        String choice = "yes";

        System.out.println("=== NUMBER GAME ===");

        while (choice.equals("yes")) {

            int number = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\n--- New Round Started ---");
            System.out.println("Guess a number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Enter a valid number!");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct!");
                    totalScore += (maxAttempts - attempts + 1);
                    roundsWon++;
                    guessedCorrectly = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too high");
                } else {
                    System.out.println("Too low");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! Number was: " + number);
            }

            System.out.println("Score: " + totalScore);
            System.out.println("Rounds won: " + roundsWon);

            // Only y/n or yes/no
            System.out.print("Play again? (yes/no): ");
            choice = sc.next().toLowerCase();

            while (!(choice.equals("y") || choice.equals("n") ||
                    choice.equals("yes") || choice.equals("no"))) {

                System.out.print("Enter only y/n or yes/no: ");
                choice = sc.next().toLowerCase();
            }

            // convert short forms
            if (choice.equals("y")) choice = "yes";
            if (choice.equals("n")) choice = "no";
        }

        System.out.println("Game ended");
        sc.close();
    }
}