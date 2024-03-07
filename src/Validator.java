import java.util.Arrays;

public class Validator {
    static boolean validateOptionMenu(int option) {
        return option != 1 && option != 2;
    }

    static boolean isValidCircuitLength(int circuit) {
        return circuit > 15 || circuit < 5;
    }

    static boolean isValidObstacleQuantity(int circuit, int obstacles) {
        return obstacles > circuit / 3;
    }

    static boolean isValidActionsRunner(String actions, int circuitLength) {
        String[] actionsList = actions.split(",");
        return !actions.matches("^([cs])(,([cs]))*?$") || actionsList.length != circuitLength;
    }

    static boolean isValidName(String name){
        return name.isBlank();
    }
}
