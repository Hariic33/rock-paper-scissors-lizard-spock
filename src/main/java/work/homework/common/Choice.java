package work.homework.common;

public enum Choice {
    ROCK("r"),
    PAPER("p"),
    SCISSORS("s"),
    LIZARD("l"),
    SPOCK("o");

    private final String userInput;

    Choice(String userInput) {
        this.userInput = userInput;
    }

    public static Choice getChoice(String userInput) {
        for (Choice choice : Choice.values()) {
            if (choice.userInput.equalsIgnoreCase(userInput)) {
                return choice;
            }
        }
        return null;
    }

    public boolean beats(Choice other) {
        return (this == ROCK && (other == SCISSORS || other == LIZARD)) ||
                (this == PAPER && (other == ROCK || other == SPOCK)) ||
                (this == SCISSORS && (other == PAPER || other == LIZARD)) ||
                (this == LIZARD && (other == PAPER || other == SPOCK)) ||
                (this == SPOCK && (other == ROCK || other == SCISSORS));
    }
}