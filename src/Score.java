import java.util.stream.Stream;

public class Score {
    public int scoreRace;
    public int failedObstacles;
    public int successObstacles;
    public int failedRun;

    public Score(int scoreRace, int failedObstacles, int successObstacles, int failedRun) {
        this.scoreRace = scoreRace;
        this.failedObstacles = failedObstacles;
        this.successObstacles = successObstacles;
        this.failedRun = failedRun;
    }

    static int calculateScoreRace(StringBuilder circuit) {
        return circuit.length() * 2;
    }

    static int calculateFailedObstacles(StringBuilder circuit) {
        return (int) Stream.of(circuit.toString().split("")).filter(s -> s.equals("/")).count();
    }

    static int calculateSuccessObstacles(StringBuilder circuit) {
        return (int) Stream.of(circuit.toString().split("")).filter(s -> s.equals("|")).count();
    }

    static int calculateFailedRun(StringBuilder circuit) {
        return (int) Stream.of(circuit.toString().split("")).filter(s -> s.equals("x")).count();
    }

    public void raceResult(String runnerName) {
        System.out.printf("\n**%s, tú resultado es:**\n",runnerName );
        System.out.println("• Obstáculos fallidos: " + failedObstacles);
        System.out.println("• Obstáculos superados: " + successObstacles);
        System.out.println("• Fallas en la carrera: " + failedRun);
        System.out.println("• Puntuación total: " + (scoreRace + successObstacles - (failedObstacles*4) - (failedRun*3)) + "/" + scoreRace);
    }
}
