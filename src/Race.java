public class Race {
    static Runner runner;
    static Speedway speedway;
    public String finalSpeedway;

    static void startRace(String name, String actions, int circuitLength, int obstacles){
        String[] actionsList = actions.split(",");
        runner = new Runner(name,actionsList);
        speedway = new Speedway(circuitLength,obstacles);

        speedway.createCircuit();


    }
}

