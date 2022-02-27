package bowlingGame;

public class Game {

    private int score = 0;
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private int nextTwoBallsForStrike(int ballNumber) {
        return rolls[ballNumber + 1] + rolls[ballNumber + 2];
    }

    private boolean isSpare(int ballNumber) {
        return rolls[ballNumber] + rolls[ballNumber + 1] == 10;
    }

    private int addNextBallForspare(int ballNumber) {
        return rolls[ballNumber + 2];
    }

    private int twoBallsInFrame(int ballNumber) {
        return rolls[ballNumber] + rolls[ballNumber + 1];
    }

    public int score() {
        int ballNumber = 0;
        rulesBowling(ballNumber);
        return score;
    }

    private void rulesBowling(int ballNumber) {
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[ballNumber])) {
                score += 10 + nextTwoBallsForStrike(ballNumber);
                ballNumber += 1;
            } else if (isSpare(ballNumber)) {
                score += 10 + addNextBallForspare(ballNumber);
                ballNumber += 2;
            } else {
                score += twoBallsInFrame(ballNumber);
                ballNumber += 2;
            }
        }
    }
}
