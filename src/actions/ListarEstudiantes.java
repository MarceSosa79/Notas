package actions;

import java.io.File;

public class ListarEstudiantes {
//listo estudiantes registrados en BBDD
    public static void ejecutar(String baseFolder) {
        File carpetaGeneral = new File(baseFolder);
        if (!carpetaGeneral.exists()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
//me aseguro que es un directorio
        File[] carpetas = carpetaGeneral.listFiles(File::isDirectory);
        if (carpetas == null || carpetas.length == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
//listo nombres de las carpetas/estudioantes
        System.out.println("Estudiantes registrados:");
        for (File carpeta : carpetas) {
            System.out.println("- " + carpeta.getName());
        }
    }
}
