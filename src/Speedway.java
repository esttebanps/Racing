import java.util.Random;

public class Speedway {
    public int circuitLength;
    public int obstacles;

    Speedway(int circuitLength, int obstacles) {
        this.circuitLength = circuitLength;
        this.obstacles = obstacles;
    }

    public StringBuilder createCircuit() {
        StringBuilder circuit = new StringBuilder("_".repeat(circuitLength));
        Random random = new Random();

        // Stream API for data manipulations
        // reads and processes data from data source (collections,array,files.etc.)
        // This list implements Stream api by default
        int[] positions = random.ints(2, circuitLength - 1)
                .filter(i -> i % 2 == 0)
                .distinct()
                .limit(obstacles)
                .toArray();
        for (int i : positions) {
            circuit.setCharAt(i, '|');
        }

        return circuit;
    }
}
