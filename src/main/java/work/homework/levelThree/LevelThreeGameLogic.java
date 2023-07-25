package work.homework.levelThree;

import work.homework.common.Choice;
import work.homework.common.GameState;

import java.util.Random;
import java.util.Scanner;

public class LevelThreeGameLogic {
    private final Choice[] choices = Choice.values();
    private final Scanner scan = new Scanner(System.in);
    private final Random random = new Random();
    private final GameState gameState;

    public LevelThreeGameLogic() {
        gameState = new GameState();
    }

    public void displayChoices(Player[] players, int numOfRounds) {
        int totalPlayers = players.length;

        int humanPlayerIndex = -1;
        for (int i = 0; i < totalPlayers; i++) {
            if (players[i].getName().equals("Player")) {
                humanPlayerIndex = i;
                break;
            }
        }

        for (int round = 1; round <= numOfRounds; round++) {
            System.out.println("\nRound " + round + ":");

            Player humanPlayer = players[humanPlayerIndex];
            for (int i = 0; i < totalPlayers; i++) {
                if (i == humanPlayerIndex) {
                    continue;
                }
                Player pcPlayer = players[i];
                System.out.println(humanPlayer.getName() + ", it's your turn against " + pcPlayer.getName() + ".");
                System.out.println("Rock-Paper-Scissors-Lizard-Spock");
                System.out.print("Enter your choice (r for rock, p for paper, s for scissors, l for lizard, o for spock): ");
                String userInput = scan.nextLine().toLowerCase();
                Choice userChoice = Choice.getChoice(userInput);
                if (userChoice == null) {
                    System.err.println("Invalid input, try again.\n");
                    round--;
                    continue;
                }
                System.out.println(humanPlayer.getName() + " chose: " + userChoice);
                Choice pcChoice = choices[random.nextInt(choices.length)];
                System.out.println(pcPlayer.getName() + " chose: " + pcChoice);
                determineTheWinner(humanPlayer, userChoice, pcPlayer, pcChoice);
            }

            for (int i = 0; i < totalPlayers; i++) {
                if (i == humanPlayerIndex) {
                    continue;
                }
                Player currentPlayer = players[i];
                for (int j = i + 1; j < totalPlayers; j++) {
                    if (j == humanPlayerIndex) {
                        continue;
                    }
                    Player otherPlayer = players[j];
                    Choice currentPlayerChoice = choices[random.nextInt(choices.length)];
                    Choice otherPlayerChoice = choices[random.nextInt(choices.length)];
                    System.out.println(currentPlayer.getName() + " chose: " + currentPlayerChoice);
                    System.out.println(otherPlayer.getName() + " chose: " + otherPlayerChoice);

                    determineTheWinner(currentPlayer, currentPlayerChoice, otherPlayer, otherPlayerChoice);
                }
            }
        }
    }

    private void determineTheWinner(Player userPlayer, Choice userChoice, Player pcPlayer, Choice pcChoice) {
        if (userChoice == pcChoice) {
            System.out.println(userPlayer.getName() + " tied against " + pcPlayer.getName() + "\n");
        } else if (userChoice.beats(pcChoice)) {
            System.out.println(userPlayer.getName() + " won this round against " + pcPlayer.getName() + "\n");
            userPlayer.incrementWins();
        } else {
            System.out.println(pcPlayer.getName() + " won this round against " + userPlayer.getName() + "\n");
            pcPlayer.incrementWins();
        }
        gameState.incrementNumOfRounds();
    }
}