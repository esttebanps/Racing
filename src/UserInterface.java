import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static void run() throws InterruptedException {

        System.out.print("\u001B[36m");
            System.out.println("==============================================");
            System.out.println("|| ¡Bienvenido a la carrera de obstáculos!! ||");
            System.out.println("==============================================\n");
        System.out.print("\u001B[0m");

        String name = null, actions = null;
        int option, obstacles = 0;
        int circuitLength = 0;
        boolean isValid;

        do {
            isValid = false;
            Scanner sc = new Scanner(System.in);


            while(!isValid){
                System.out.println("**Ingresa tu username: ");
                name = sc.nextLine();
                if (!Validator.isValidName(name)){
                    isValid=true;
                }else {
                    System.err.println("\u001B[31m⚠️ ¡Ups! Olvidaste ingresar tú nombre.. ⚠️\u001B[0m");
                    System.err.println("\u001B[31m⚠️ Intenta de nuevo.. ⚠️\u001B[0m");
                }

            }

            System.out.printf("Hola %s\n", name);
            System.out.println("Sigue las instrucciones para jugar.");
            isValid = false;
            while (!isValid) {
                try {
                    System.out.println("**Ingresa el tamaño de la pista (5 a 15): ");
                    circuitLength = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un número entero válido.. ⚠️\u001B[0m");
                }
                if (!Validator.isValidCircuitLength(circuitLength)) {
                    isValid = true;
                } else {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un numero entero entre 5 y 15. ⚠️\u001B[0m");
                }
            }

            isValid = false;
            while (!isValid) {
                try {
                    System.out.println("**Ingresa la cantidad de obstáculos, máximo " + circuitLength / 3 + ": ");
                    obstacles = Integer.parseInt(sc.nextLine());
                    if (!Validator.isValidObstacleQuantity(circuitLength, obstacles)) {
                        isValid = true;
                    } else {
                        System.err.println("\u001B[31m⚠️ ¡Error! Ingresa una cantidad valida.. ⚠️\u001B[0m");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un número entero válido.. ⚠️\u001B[0m");
                }
            }

            isValid = false;
            while (!isValid) {
                System.out.println("**Ingresa las secuencia de acciones separadas por (,): ");
                System.out.println("* Ingresa c para correr");
                System.out.println("* Ingresa s para saltar");
                actions = sc.nextLine();
                if (!Validator.isValidActionsRunner(actions, circuitLength)) {
                    isValid = true;
                } else {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa una secuencia de pasos vaida. ej: s,c,s,c ⚠️\u001B[0m");
                }
            }

            Race.startRace(name, actions, circuitLength, obstacles);

            do {
                System.out.println("¿otra partida?");
                System.out.println("1.Sí");
                System.out.println("2.No");

                while (!sc.hasNextInt()) {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un número entero válido.. ⚠️\u001B[0m");
                    sc.nextLine();
                }
                option = sc.nextInt();

                if (Validator.validateOptionMenu(option)) {
                    System.err.println("\u001B[31m⚠️ Ingresa una opción correcta.. ⚠️\u001B[0m");
                }
            } while (Validator.validateOptionMenu(option));

            isValid = option == 1;

        } while (isValid);

    }
}
