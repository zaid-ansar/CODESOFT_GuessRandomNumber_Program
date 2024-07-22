import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {
    public GuessRandomNumber() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsWon = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between " + lowerRange + " and " + upperRange + ".");
        System.out.println("Can you guess it? You have " + maxAttempts + " attempts.");

        String playAgain;
        do {
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;

            while(attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                ++attempts;
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    ++roundsWon;
                    break;
                }

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while(playAgain.equalsIgnoreCase("yes"));

        System.out.println("Game over! Your total score:");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);
        scanner.close();
    }
}