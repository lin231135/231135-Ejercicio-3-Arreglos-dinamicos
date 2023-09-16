import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();
        Sede sede = new Sede(null);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear una nueva sede universitaria.");
            System.out.println("2. Registrar información de un estudiante.");
            System.out.println("3. Ingresar las notas de los exámenes para un estudiante.");
            System.out.println("4. Calcular y mostrar estadísticas.");
            System.out.println("5. Mostrar la cantidad de alumnos registrados en una sede y las notas más bajas y altas.");
            System.out.println("6. Salir del programa.");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la dirección de la nueva sede: ");
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    String direccionSede = scanner.nextLine();
                    universidad.crearSede(direccionSede);
                    System.out.println("Sede creada con éxito.");
                    break;

                // Implementa los otros casos aquí según tus necesidades.
                case 2:
                    sede.llenarInformacionDeEstudianteYExamenes();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
}
