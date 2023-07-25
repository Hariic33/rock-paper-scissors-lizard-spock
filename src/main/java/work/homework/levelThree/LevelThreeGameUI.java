package work.homework.levelThree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LevelThreeGameUI {
    String[] pcOpponents = {"Shaquille O’atmeal", "RockGPT", "Toaster", "Fleasy E", "HairyPoppins", "Fedora the Explorer", "Bread Pitt", "Severus Vape", "Cereal Killer"};
    private final LevelThreeGameLogic gameLogic = new LevelThreeGameLogic();
    private static final int MAX_OPPONENTS = 9;
    private static final int MAX_ROUNDS = 5;

    void startGame() {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many number of computer opponents will there be? (1-9)");
        int numOfOpponents = scan.nextInt();
        if (numOfOpponents < 1 || numOfOpponents > MAX_OPPONENTS) {
            System.err.println("Invalid input. Number of opponents should be between 1 and " + MAX_OPPONENTS + ".");
            return;
        }

        System.out.println("How many rounds will there be? (1-5)");
        int numOfRounds = scan.nextInt();
        if (numOfRounds < 1 || numOfRounds > MAX_ROUNDS) {
            System.err.println("Invalid input. Number of rounds should be between 1 and " + MAX_ROUNDS + ".");
            return;
        }

        System.out.println("\nLet us begin...");

        Player[] players = new Player[numOfOpponents + 1];

        for (int i = 0; i < numOfOpponents; i++) {
            players[i] = new Player(pcOpponents[i]);
        }
        players[numOfOpponents] = new Player("Player");
        players[numOfOpponents].setHuman(true);

        gameLogic.displayChoices(players, numOfRounds);

        System.out.println("\n--- Leaderboard ---");
        Arrays.sort(players, Comparator.comparingInt(Player::getWins).reversed());
        for (Player player : players) {
            System.out.println(player);
        }
    }
}