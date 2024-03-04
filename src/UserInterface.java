import java.util.Scanner;

public class UserInterface {
    static Scanner sc = new Scanner(System.in);

    static void run() {
        System.out.println("==============================================");
        System.out.println("|| ¡Bienvenido a la carrera de obstáculos!! ||");
        System.out.println("==============================================\n");
        int option = 0;
        boolean yes;
        do {
            int circuitLength = 0;
            int obstacles = 0;
            String name;

            System.out.print("**Ingresa tu nombre: ");
            name = sc.nextLine();

            do {
                try {
                    System.out.println("**Ingresa el tamaño de la pista (5 a 15): ");
                    System.out.print(">> ");
                    circuitLength = Integer.parseInt(sc.nextLine());
                    if (Validator.isValidCircuitLength(circuitLength)) {
                        System.err.println("Ingresa otro valor (5 a 15)");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ingresa solamente numeros");
                }

            } while (Validator.isValidCircuitLength(circuitLength));

            boolean bien = true;
            do {
                try {
                    System.out.println("**Ingresa la cantidad de obstáculos, máximo " + (circuitLength / 2) + ": ");
                    obstacles = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Ingresa un número entero.");
                    continue;
                }

                if (!Validator.isValidObstacleQuantity(circuitLength,obstacles)) {
                    System.err.printf("Ingresa un número entero menor o igual a %d.\n", circuitLength / 2);
                }
                bien = false;
            } while (bien);

            do {
                System.out.println("¿otra partida?");
                System.out.println("1.Sí");
                System.out.println("2.No");
                try {
                    System.out.print(">> ");
                    option = Integer.parseInt(sc.nextLine());
                    if (Validator.validateOptionMenu(option)) {
                        System.err.println("Ingresa una opción correcta");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ingresa solo números");
                }
            } while (Validator.validateOptionMenu(option));

            yes = option == 1;

        } while (yes);
    }
}
