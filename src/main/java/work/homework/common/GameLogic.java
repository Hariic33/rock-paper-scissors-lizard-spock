package work.homework.common;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final Choice[] choices = Choice.values();
    private final Scanner scan = new Scanner(System.in);
    private final Random random = new Random();

    public void displayChoices(GameState gameState, int maxRounds) {
        while (gameState.getNumOfRounds() < maxRounds) {
            System.out.println("Rock-Paper-Scissors-Lizard-Spock");
            System.out.print("Your turn (Enter r for rock, p for paper, s for scissors, l for lizard, o for spock): ");
            String userInput = scan.nextLine().toLowerCase();

            Choice userChoice = Choice.getChoice(userInput);
            if (userChoice == null) {
                System.err.println("Invalid input, try again.\n");
                continue;
            }

            System.out.println("\nPlayer chose: " + userChoice);
            Choice pcChoice = choices[random.nextInt(choices.length)];
            System.out.println("Computer's turn: " + pcChoice + "\n");

            determineTheWinner(gameState, userChoice, pcChoice);
        }
    }

    private void determineTheWinner(GameState gameState, Choice userChoice, Choice pcChoice) {
        if (userChoice == pcChoice) {
            System.out.println("Player tied against Computer!\n");
        } else if (userChoice.beats(pcChoice)) {
            System.out.println("Player won this round\n");
            gameState.incrementUserWins();
        } else {
            System.out.println("Computer won this round!\n");
            gameState.incrementPcWins();
        }
        gameState.incrementNumOfRounds();
    }
}