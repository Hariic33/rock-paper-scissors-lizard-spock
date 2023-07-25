package work.homework.common;

public class GameUI {
    private static final int MAX_ROUNDS = 3;
    private final GameLogic gameLogic = new GameLogic();
    private final GameState gameState = new GameState();
    public static boolean continueGame = true;

    public int getMaxRounds() {
        return MAX_ROUNDS;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public GameState getGameState() {
        return gameState;
    }

    public static void displayOverallResult(GameState gameState) {
        if (gameState.getUserWins() > gameState.getPcWins()) {
            System.out.println("Player is the winner!\n");
            gameState.reset();
        } else if (gameState.getPcWins() > gameState.getUserWins()) {
            System.out.println("Computer is the winner!");
            continueGame = false;
        } else {
            System.out.println("It's a tie!");
            continueGame = false;
        }
    }
}