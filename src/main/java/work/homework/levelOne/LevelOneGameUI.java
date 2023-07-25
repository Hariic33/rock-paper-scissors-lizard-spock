package work.homework.levelOne;

import work.homework.common.GameUI;

public class LevelOneGameUI {

    void startGame() {
        GameUI gameUI = new GameUI();
        System.out.println("Let us begin...");
        gameUI.getGameLogic().displayChoices(gameUI.getGameState(), gameUI.getMaxRounds());
        GameUI.displayOverallResult(gameUI.getGameState());
    }
}