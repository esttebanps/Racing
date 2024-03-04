public class Validator {
    static boolean validateOptionMenu(int option){
        return option != 1 && option !=2;
    }

    static boolean isValidCircuitLength(int circuit) {
        return circuit > 15 || circuit < 5;
    }

    static boolean isValidObstacleQuantity(int circuit, int obstacles) {
        return obstacles <= (circuit / 2);
    }
}
