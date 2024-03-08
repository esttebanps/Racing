import java.io.Console;
import java.util.Arrays;
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

// Question 1: name
            while(!isValid){
                System.out.println("**Ingresa tu username: ");
                name = sc.nextLine();
                if (!Validator.isValidName(name)){
                    isValid=true;
                }else {
                    System.err.println("\u001B[31m⚠️ ¡Ups! Olvidaste ingresar tú nombre.. ⚠️\u001B[0m");
                    System.err.println("**Intenta de nuevo: ");
                }

            }

            System.out.printf("Hola %s\n", name);
            System.out.println("Sigue las instrucciones para jugar.");
            isValid = false;

// Question 2: floor
            while (!isValid) {
                try {
                    System.out.println("**Ingresa el tamaño de la pista (5 a 15): ");
                    circuitLength = Integer.parseInt(sc.nextLine());
                    if (!Validator.isValidCircuitLength(circuitLength)) {
                        isValid = true;
                    } else {
                        System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un numero entero entre 5 y 15. ⚠️\u001B[0m");
                        System.err.println("**Intenta de nuevo: ");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un número entero válido.. ⚠️\u001B[0m");
                    System.err.println("**Intenta de nuevo: ");
                }
            }
            isValid = false;

// Question 3: Obstacles
            while (!isValid) {
                try {
                    System.out.println("**Ingresa la cantidad de obstáculos, máximo " + circuitLength / 3 + ": ");
                    obstacles = Integer.parseInt(sc.nextLine());
                    if (!Validator.isValidObstacleQuantity(circuitLength, obstacles)) {
                        isValid = true;
                    } else {
                        System.err.println("\u001B[31m⚠️ ¡Error! Ingresa una cantidad valida.. ⚠️\u001B[0m");
                        System.err.println("**Intenta de nuevo: ");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\u001B[31m⚠️ ¡Error! Ingresa un número entero válido.. ⚠️\u001B[0m");
                }
            }
            isValid = false;

// Question 4: Actions runner
            while (!isValid) {
                System.out.println("** Ingresa la secuencia de acciones que deseas realizar, separadas por comas (,).");
                System.out.println("** Ejemplo: s,c,s,c");
                System.out.printf("** Debes ingresar %s acciones en total.\n", circuitLength);
                System.out.println("** Puedes usar las siguientes acciones: ");
                System.out.println("* C - para correr");
                System.out.println("* S - para saltar");
                actions = sc.nextLine().toLowerCase();
                if (!Validator.isValidActionsRunner(actions, circuitLength)) {
                    isValid = true;
                }else if (actions.isBlank()) {
                    System.out.println("\u001B[31m💡 Oops! Parece que olvidaste ingresar las acciones para la carrera.\u001B[0m");
                } else {
                    System.err.println("\u001B[31m⚠️ ¡Error! La secuencia de acciones '" + actions + "' no es válida. Debes ingresar " + circuitLength + " acciones. ⚠️\u001B[0m");
                    System.out.println("Ejemplo: s,c,s,c");
                    System.err.println("**Vuelve a ingresar las acciones de nuevo:");
                }
            }

            Race.startRace(name, actions, circuitLength, obstacles);

// Question 5: New game
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
