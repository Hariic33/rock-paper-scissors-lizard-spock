package work.homework.levelThree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String name;
    private int wins;
    private boolean isHuman;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.isHuman = false;
    }

    public void incrementWins() {
        wins++;
    }

    @Override
    public String toString() {
        return name + ": " + wins + " wins";
    }
}