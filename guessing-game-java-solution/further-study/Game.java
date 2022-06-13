import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/** A number guessing game. */
public class Game {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // for getting user input
    Random rand = new Random(); // for generating random number

    // Greet the player, get their name
    System.out.println("Howdy, what's your name?");
    System.out.println("(type in your name)");
    String name = input.nextLine();

    int guessCount = 0;

    // Let users play multiple rounds
    Boolean keepPlaying = true;

    // Limit the number of guesses a user gets
    int maxGuesses = 50;

    // Track best scores
    int bestGuessCount = maxGuesses;

    // Initialize playerGuess to something obviously wrong
    int playerGuess = -1;
    while (keepPlaying) {
      // Generate random number
      System.out.println(name + ", I'm thinking of a number between 0 and 100.");
      int number = rand.nextInt(101);

      // Explain how game works
      System.out.println("Can you guess what the number is?");

      // Initialize playerGuess to something obviously wrong
      // int playerGuess = -1;

      // Loop for getting/validating player's guess
      Boolean guessIsValid = false;
      while (!guessIsValid) {
        System.out.println("Enter your guess:");

        try {
          playerGuess = input.nextInt();

          if (playerGuess >= 1 && playerGuess <= 100) {
            guessIsValid = true;
          } else {
            System.out.println(playerGuess + " is not a number between 1-100, try again");
          }
        } catch (InputMismatchException e) {
          System.out.println(input.next() + " is not a valid number, try again");
        }
      }

      // At this point, the player guessed a valid number.

      guessCount += 1;

      if (guessCount >= maxGuesses) {
        System.out.println("Sorry, you exceeded the maximum number of guesses allowed.");
      } else {

        if (playerGuess < number) {
          System.out.println("Your guess is too low, try again.");
        } else if (playerGuess < number) {
          System.out.println("Your guess is too high, try again.");
        } else {
          System.out.println("Well done " + name);
          System.out.println("You found my number in " + guessCount + " tries!");
        }

        // Player beat their personal best
        if (guessCount < bestGuessCount) {
          System.out.println("You set a new personal best!");

          bestGuessCount = guessCount;
        }
      }

      // Loop for getting/validating if player wants to play again
      Boolean playAgainIsValid = false;
      while (!playAgainIsValid) {
        System.out.println("Would you like to play again? (Y or N)");

        String answer = input.nextLine().trim().toLowerCase();

        if (answer.equals("y") || answer.equals("n")) {
          System.out.println("Please answer with 'Y' or 'N' only!");
        } else {
          playAgainIsValid = true;
          keepPlaying = answer == "y";
        }
      }
    }

    System.out.println("Thanks for playing.");
    System.out.println("Your personal best was " + bestGuessCount + "!");
  }
}