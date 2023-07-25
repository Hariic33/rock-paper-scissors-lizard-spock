package work.homework.common;

import lombok.Data;

@Data
public class GameState {
    private int numOfRounds;
    private int userWins;
    private int pcWins;

    public GameState() {
        reset();
    }

    public void reset() {
        numOfRounds = 0;
        userWins = 0;
        pcWins = 0;
    }

    public void incrementNumOfRounds() {
        numOfRounds++;
    }

    public void incrementUserWins() {
        userWins++;
    }

    public void incrementPcWins() {
        pcWins++;
    }
}