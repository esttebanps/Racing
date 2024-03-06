import java.io.Console;
import java.util.Scanner;

public class UserInterface {

    static void run() throws InterruptedException {

        System.out.print("\u001B[36m");
            System.out.println("==============================================");
            System.out.println("|| ¡Bienvenido a la carrera de obstáculos!! ||");
            System.out.println("==============================================\n");
        System.out.print("\u001B[0m");

        String name, actions;
        int option, obstacles;
        int circuitLength = 0;
        boolean yes;

        do {

            Scanner sc = new Scanner(System.in);

            System.out.println("**Ingresa tu username: ");
            name = sc.nextLine();
            System.out.printf("Hola %s\n", name);
            System.out.println("Sigue las instrucciones para jugar.");

            do {
                try {
                    System.out.println("**Ingresa el tamaño de la pista (5 a 15): ");
                    circuitLength = Integer.parseInt(sc.nextLine());
                    if (Validator.isValidCircuitLength(circuitLength)) {
                        System.err.println("Ingresa otro valor (5 a 15): ");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ingresa solamente numeros: ");
                }
            } while (Validator.isValidCircuitLength(circuitLength));

            do {
                System.out.println("**Ingresa la cantidad de obstáculos, máximo " + circuitLength / 3 + ": ");

                while (!sc.hasNextInt()) {
                    System.err.println("¡Error! Ingresa un número entero válido.");
                    sc.nextLine();
                }

                obstacles = sc.nextInt();

                if (Validator.isValidObstacleQuantity(circuitLength, obstacles)) {
                    System.err.println("Ingresa un número menor o igual a. " + circuitLength / 3);
                }
            } while (Validator.isValidObstacleQuantity(circuitLength, obstacles));

            do {
                System.out.println("**Ingresa las secuencia de acciones separadas por (,): ");
                System.out.println("* Ingresa c para correr");
                System.out.println("* Ingresa s para saltar");
                actions = sc.next();
                if (Validator.isValidActionsRunner(actions, circuitLength)) {
                    System.err.println("Intenta de nuevo");
                }
            } while (Validator.isValidActionsRunner(actions, circuitLength));


            Race.startRace(name, actions, circuitLength, obstacles);

            do {
                System.out.println("¿otra partida?");
                System.out.println("1.Sí");
                System.out.println("2.No");

                while (!sc.hasNextInt()) {
                    System.err.println("¡Error! Ingresa un número entero válido.");
                    sc.nextLine();
                }
                option = sc.nextInt();

                if (Validator.validateOptionMenu(option)) {
                    System.err.println("Ingresa una opción correcta: ");
                }
            } while (Validator.validateOptionMenu(option));

            yes = option == 1;

        } while (yes);
    }
}
