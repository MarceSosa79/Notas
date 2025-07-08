package services;

import java.io.*;
import java.util.*;
import models.Student;

public class FileManager {
    private static final String Note = "notas";

    public static void baseFolder() {
        File base = new File(Note);
        if (!base.exists()) {
            base.mkdir();
        }
    }

    public static void addNotes(Student student, ArrayList<String> notes) throws IOException {
        File folder = student.getFolder();
        File file = student.getNotesFile();

        if (!folder.exists()) folder.mkdir();

        FileWriter writer = new FileWriter(file, true);
        for (String note : notes) {
            writer.write(note + "\n");
        }
        writer.close();
    }

    public static void showNotes(Student student) {
        File file = student.getNotesFile();
        String name = student.getName();

        if (!file.exists()) {
            System.out.println("El archivo de notas no existe para el estudiante: " + name);
            return;
        }

        System.out.println("Notas de " + name + ":");
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public static void listStudents() {
        File baseFolder = new File(Note);

        if (!baseFolder.exists()) {
            System.out.println("La carpeta base no existe.");
            return;
        }

        File[] studentFolders = baseFolder.listFiles(File::isDirectory);

        if (studentFolders == null || studentFolders.length == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.println("Estudiantes registrados:");
        for (File folder : studentFolders) {
            System.out.println("- " + folder.getName());
        }
    }

    public static String deleteStudent(Student student) {
        File folder = student.getFolder();
        File file = student.getNotesFile();

        if (!folder.exists()) {
            return "El estudiante no existe.";
        }

        boolean fileDeleted = !file.exists() || file.delete();
        boolean folderDeleted = folder.delete();

        if (fileDeleted && folderDeleted) {
            return "Estudiante eliminado correctamente.";
        } else {
            return "No se pudo eliminar completamente. Verifica si el archivo está en uso.";
        }
    }
}
