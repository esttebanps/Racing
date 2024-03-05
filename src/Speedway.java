
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < obstacles; i++) {
            int randomPosition;
            do {
                randomPosition = (int) (Math.random() * circuitLength - 1) + 1;
            } while (positions.contains(randomPosition) || randomPosition % 2 == 0);
            positions.add(randomPosition);
        }

        for (int i : positions) {
            circuit.setCharAt(i, '|');
        }

        System.out.println(circuit);

        return circuit;
    }
}
