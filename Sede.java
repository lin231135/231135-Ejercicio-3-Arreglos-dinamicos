import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sede {
    private String direccion;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    
    public Sede(String direccion) {
        this.direccion = direccion;
        
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float notaMasAlta() {
        float maxNota = Float.MIN_VALUE;
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : estudiante.getExamenes()) {
                maxNota = Math.max(maxNota, examen.getNota());
            }
        }
        return maxNota;
    }

    public float notaMasBaja() {
        float minNota = Float.MAX_VALUE;
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : estudiante.getExamenes()) {
                minNota = Math.min(minNota, examen.getNota());
            }
        }
        return minNota;
    }

    public void llenarInformacionDeEstudianteYExamenes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellidoEstudiante = scanner.nextLine();
        System.out.print("Ingrese el código único del estudiante: ");
        int codigoEstudiante = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la fecha de nacimiento del estudiante: ");
        String fechaNacimientoEstudiante = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico del estudiante: ");
        String correoEstudiante = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, codigoEstudiante, fechaNacimientoEstudiante, correoEstudiante);

        System.out.print("Ingrese la cantidad de exámenes a ingresar para este estudiante: ");
        int cantidadExamenes = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        ArrayList<Examen> examenes = new ArrayList<>();
        for (int i = 1; i <= cantidadExamenes; i++) {
            System.out.print("Ingrese la nota del examen " + i + ": ");
            float notaExamen = scanner.nextFloat();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese la materia del examen " + i + ": ");
            String materiaExamen = scanner.nextLine();

            Examen examen = new Examen(materiaExamen, notaExamen);
            examenes.add(examen);
        }

        estudiante.agregarExamenes(examenes);
        estudiantes.add(estudiante);

        System.out.println("Estudiante registrado exitosamente en la sede.");
        System.out.println(estudiante);
    }

    public void calcularEstadisticas() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la dirección de la sede para la cual desea calcular las estadísticas: ");
        String direccionSede = scanner.nextLine();

        Sede sede = buscarSedePorDireccion(direccionSede, null);

        if (sede == null) {
            System.out.println("Sede no encontrada.");
            return;
        }

        ArrayList<Float> todasLasNotas = new ArrayList<>();

        // Recopilar todas las notas de los exámenes de todos los estudiantes en la sede
        for (Estudiante estudiante : sede.estudiantes) {
            for (Examen examen : estudiante.getExamenes()) {
                todasLasNotas.add(examen.getNota());
            }
        }

        if (todasLasNotas.isEmpty()) {
            System.out.println("No hay notas de exámenes registradas en esta sede.");
            return;
        }

        // Calcular promedio
        float promedio = calcularPromedio(todasLasNotas);
        System.out.println("Promedio de notas en la sede: " + promedio);

        // Calcular mediana
        float mediana = calcularMediana(todasLasNotas);
        System.out.println("Mediana de notas en la sede: " + mediana);

        // Calcular moda
        ArrayList<Float> moda = calcularModa(todasLasNotas);
        System.out.print("Moda de notas en la sede: ");
        for (float valorModa : moda) {
            System.out.print(valorModa + " ");
        }
        System.out.println();

        // Calcular desviación estándar
        float desviacionEstandar = calcularDesviacionEstandar(todasLasNotas);
        System.out.println("Desviación estándar de notas en la sede: " + desviacionEstandar);
    }

    // Resto de las funciones de la clase Sede

    // Función para buscar una sede por dirección (insensible a mayúsculas y minúsculas)
    public static Sede buscarSedePorDireccion(String direccion, ArrayList<Sede> sedes) {
        for (Sede sede : sedes) {
            if (sede.getDireccion().equalsIgnoreCase(direccion)) {
                return sede; // Se encontró la sede
            }
        }
        return null; // No se encontró la sede
    }

    // Función para calcular el promedio de una lista de números
    private float calcularPromedio(ArrayList<Float> numeros) {
        float suma = 0;
        for (float numero : numeros) {
            suma += numero;
        }
        return suma / numeros.size();
    }

    // Función para calcular la mediana de una lista de números
    private float calcularMediana(ArrayList<Float> numeros) {
        Collections.sort(numeros);
        int n = numeros.size();
        if (n % 2 == 0) {
            // Si hay un número par de elementos, la mediana es el promedio de los dos números del medio
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (numeros.get(medio1) + numeros.get(medio2)) / 2;
        } else {
            // Si hay un número impar de elementos, la mediana es el número del medio
            return numeros.get(n / 2);
        }
    }

    // Función para calcular la moda de una lista de números
    private ArrayList<Float> calcularModa(ArrayList<Float> numeros) {
        ArrayList<Float> moda = new ArrayList<>();
        int maxFrecuencia = 0;

        for (float numero : numeros) {
            int frecuencia = Collections.frequency(numeros, numero);

            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda.clear();
                moda.add(numero);
            } else if (frecuencia == maxFrecuencia && !moda.contains(numero)) {
                moda.add(numero);
            }
        }

        return moda;
    }

    // Función para calcular la desviación estándar de una lista de números
    private float calcularDesviacionEstandar(ArrayList<Float> numeros) {
        float promedio = calcularPromedio(numeros);
        float sumatoria = 0;

        for (float numero : numeros) {
            sumatoria += Math.pow(numero - promedio, 2);
        }

        float varianza = sumatoria / numeros.size();
        return (float) Math.sqrt(varianza);
    }
}
