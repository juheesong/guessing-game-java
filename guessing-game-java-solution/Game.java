import java.util.Scanner;
import java.util.Random;

/** A number guessing game. */
public class Game {
  public static void main(String[] args) {
    System.out.println("Welcome to the Guessing Game!");

    Scanner input = new Scanner(System.in);

    // Get user's name
    System.out.println("Enter your name:");
    String name = input.nextLine();

    System.out.println(name + ", I'm thinking of a number between 0 and 100.");

    // Generate random number
    Random rand = new Random();
    int number = rand.nextInt(101);

    System.out.println("Try to guess the number.");

    int guessCount = 0;
    boolean guessIsCorrect = false;
    while (!guessIsCorrect) {
      System.out.println("Enter your guess:");

      int playerGuess = input.nextInt();
      guessCount += 1;

      if (playerGuess < number) {
        System.out.println("Your guess is too low, try again.");
      } else if (playerGuess < number) {
        System.out.println("Your guess is too high, try again.");
      } else {
        guessIsCorrect = true;  // this will exit the while loop

        System.out.println("Well done " + name);
        System.out.println("You found my number in " + guessCount + " tries!");
      }
    }

    System.out.println("Thanks for playing.");
  }
}
