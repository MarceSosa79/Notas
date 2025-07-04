package enums;


public enum MenuOption {
    REGISTER(1, "Registrar estudiante"),
    SHOW_NOTES(2, "Consultar notas de un estudiante"),
    LIST(3, "Listar estudiantes"),
    DELETE(4, "Eliminar datos de alumno"),
    EXIT(5, "Salir");

//Valores de enum con sus valores y descripciones
    private final int value;
    private final String description;

// Constructor
    MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }
//Getter
    public static MenuOption fromOption(int option) {
        for (MenuOption menuOption : values()) {
            if (menuOption.value == option) return menuOption;
        }
        return null;
    }
//printMenu
    public static void printMenu() {
        System.out.println("\nSistema de Registro de Notas");
        for (MenuOption menuOption : values()) {
            System.out.println(menuOption.value + ". " + menuOption.description);
        }
    }
}
