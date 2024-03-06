import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Race {
    static Runner runner;
    static Speedway speedway;
    static StringBuilder finalSpeedway;

    static void startRace(String name, String actions, int circuitLength, int obstacles) throws InterruptedException {
        String[] actionsList = actions.split(",");
        runner = new Runner(name, actionsList);
        speedway = new Speedway(circuitLength, obstacles);
        StringBuilder circuit = speedway.createCircuit();

        System.out.println("=== INICIA LA CARRERA ===");


        for (int i = 0; i < circuitLength; i++) {
            if (Objects.equals(actionsList[i], "c") && circuit.charAt(i) == '|') {
                System.err.println("**¡El atleta choca con un obstáculo!**");
                circuit.setCharAt(i, '/');
            } else if (Objects.equals(actionsList[i], "s") && circuit.charAt(i) == '_') {
                System.err.println("**¡El atleta salta sin razon!**");
                circuit.setCharAt(i, 'x');
            } else {
                System.out.println("bien hecho!");
            }
            System.out.println(circuit.substring(0, i + 1));
            Thread.sleep(1000);
        }
    }
}

