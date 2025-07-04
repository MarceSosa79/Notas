package actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistroEstudiante {
//registro estudiante y notas
    public static void ejecutar(Scanner scanner, String baseFolder) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        File carpetaEstudiante = new File(baseFolder + File.separator + nombre);
//me fijo si la carpeta existe
        if (!carpetaEstudiante.exists()) {
            carpetaEstudiante.mkdirs();
        }
//si no existe la creamos
        File archivoNotas = new File(carpetaEstudiante, "notas.txt");
//chequeo que el archivo notas exista
        try (FileWriter writer = new FileWriter(archivoNotas, true)) {
//si existe archivo agrego con append            
            while (true) {
                System.out.print("Ingrese el nombre de la tarea (o 'fin' para terminar): ");
                String tarea = scanner.nextLine();
                if (tarea.equalsIgnoreCase("fin")) break;
//salgo del bucle con "fin"
                System.out.print("Ingrese la nota (entero): ");
                int nota;
             
                try {
                    nota = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Nota invalida. Intente nuevamente.");
                    continue;
                }
//escribo los dato en el archivo
                writer.write(tarea + ": " + nota + "\n");
            }
            System.out.println("Notas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las notas: " + e.getMessage());
        }
    }
}
