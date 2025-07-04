package actions;

import java.io.File;
import java.util.Scanner;

public class EliminarEstudiante {
// Eliminar un estudiante y sus notas
    public static void ejecutar(Scanner scanner, String baseFolder) {
        System.out.print("Ingrese el nombre del estudiante a eliminar: ");
        String nombre = scanner.nextLine();
        File carpeta = new File(baseFolder + File.separator + nombre);
        File archivo = new File(carpeta, "notas.txt");
//verifico existencia de archivo y carpeta
        boolean archivoEliminado = archivo.exists() && archivo.delete();
        boolean carpetaEliminada = carpeta.exists() && carpeta.delete();
//aviso si el archivo y la carpeta fueron eliminados
        if (archivoEliminado || carpetaEliminada) {
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontró al estudiante o ya fue eliminado.");
        }
    }
}

