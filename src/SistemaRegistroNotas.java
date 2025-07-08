import java.util.*;
import models.Student;
import services.FileManager;

public class SistemaRegistroNotas {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileManager.baseFolder();

        while (true) {
            System.out.println("\nSistema de Registro de Notas");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Consultar notas de un estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Desmatricular alumno");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del estudiante: ");
                    Student student = new Student(scanner.nextLine());
                    ArrayList<String> notas = new ArrayList<>();

                    while (true) {
                        System.out.print("Ingrese tarea y nota (ej: Tarea_1: 8), o 'fin' para terminar: ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("fin")) break;
                        notas.add(input);
                    }

                    try {
                        FileManager.addNotes(student, notas);
                        System.out.println("Notas guardadas correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al guardar notas.");
                    }
                }

                case 2 -> {
                    System.out.print("Nombre del estudiante: ");
                    Student s = new Student(scanner.nextLine());
                    FileManager.showNotes(s);
                }

                case 3 -> FileManager.listStudents();

                case 4 -> {
                    System.out.print("Nombre del estudiante a eliminar: ");
                    Student s = new Student(scanner.nextLine());
                    System.out.println(FileManager.deleteStudent(s));
                }

                case 5 -> {
                    System.out.println("Saliendo del sistema.");
                    return;
                }

                default -> System.out.println("Opción no válida.");
            }
        }
    }
}

