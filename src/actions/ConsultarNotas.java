package actions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ConsultarNotas {

    //consultar notas de un estudiante
    public static void ejecutar(Scanner scanner, String baseFolder) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        File archivo = new File(baseFolder + File.separator + nombre + File.separator + "notas.txt");
//si el archivo existe leo las notas
        if (!archivo.exists()) {
            System.out.println("No se encontraron notas para este estudiante.");
            return;
        }
//leo el archivo de notas
        System.out.println("\n");
        System.out.println("Notas de " + nombre + ":");
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }           
        System.out.println("\n");
            //si no tengo notas
        } catch (IOException e) {
            System.out.println("Error al leer las notas: " + e.getMessage());
        }
    }
}

