public class Score {
    public int scoreRace;
    public int scoreRunner;

    Score(int scoreRace, int scoreRunner) {
        this.scoreRace = scoreRace;
        this.scoreRunner = scoreRunner;
    }

    static int calculateScoreRunner(int scoreRace) {
        return 1;
    }

    static int calculateScoreRace(int circuitLength) {
        return 1;
    }
}
