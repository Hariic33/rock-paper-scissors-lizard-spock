package work.homework.levelTwo;

import work.homework.common.GameUI;

import static work.homework.common.GameUI.continueGame;

public class LevelTwoGameUI {
    String[] pcOpponents = {"Shaquille O’atmeal", "RockGPT", "Toaster"};

    void startGame() {
        GameUI gameUI = new GameUI();
        System.out.println("Let us begin...");
        for (String opponent : pcOpponents) {
            if (!continueGame) {
                break;
            }
            System.out.println("Your opponent is: " + opponent + "\n");
            gameUI.getGameLogic().displayChoices(gameUI.getGameState(), gameUI.getMaxRounds());
            GameUI.displayOverallResult(gameUI.getGameState());
        }
    }
}