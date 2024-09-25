package NumberGame;

import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 10; // Number of attempts allowed
        int maxPoints = 100;  // Max points for guessing in the first attempt
        int totalScore = 0;
        int rounds = 2; // Number of rounds
        
        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int roundPoints = maxPoints; // Start with max points for the round
            boolean hasWon = false;
            
            System.out.println("Round " + round + ": Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++; 
                
                if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    hasWon = true;
                    break;
                }
                
                // Deduct points for each incorrect attempt
                roundPoints -= (maxPoints / maxAttempts); 
            }
            
            if (hasWon) {
                System.out.println("You scored " + roundPoints + " points this round.");
                totalScore += roundPoints; // Add points to total score
            } else {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
                System.out.println("You scored 0 points this round.");
            }
        }
        
        System.out.println("Game Over. Your total score: " + totalScore);
    }
}
