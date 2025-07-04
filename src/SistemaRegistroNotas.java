import java.io.File;
import java.util.Scanner;

import actions.ConsultarNotas;
import actions.EliminarEstudiante;
import actions.ListarEstudiantes;
import actions.RegistroEstudiante;
import enums.MenuOption;

public class SistemaRegistroNotas {
    private static final Scanner sc = new Scanner(System.in);
    private static final String BASE_FOLDER = "notas";

    public static void main(String[] args) {
        File notasFolder = new File(BASE_FOLDER);
        if (!notasFolder.exists()) {
            notasFolder.mkdir();
        }

        while (true) {
            MenuOption.printMenu();
            System.out.print("Seleccione una opcion: ");
            int option;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {                
                System.out.println("\n");
                System.out.println("Entrada invalida debe ser un entero. Intente nuevamente.");
                continue;
            }

            MenuOption selected = MenuOption.fromOption(option);
            if (selected == null) {
                System.out.println("\n");
                System.out.println("Opcion invalida. Intente nuevamente.");
                continue;
            }
            System.out.println("\n");
            switch (selected) {
                case REGISTER:
                    RegistroEstudiante.ejecutar(sc, BASE_FOLDER);
                    break;
                case SHOW_NOTES:
                    ConsultarNotas.ejecutar(sc, BASE_FOLDER);
                    break;
                case LIST:
                    ListarEstudiantes.ejecutar(BASE_FOLDER);
                    break;
                case DELETE:
                    EliminarEstudiante.ejecutar(sc, BASE_FOLDER);
                    break;
                case EXIT:
                    System.out.println("Saliendo del sistema. Hasta luego!");
                    return;
            }
        }
    }
}

