package models;

import java.io.File;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public File getFolder() {
        return new File("notas/" + name);
    }

    public File getNotesFile() {
        return new File(getFolder(), "notas.txt");
    }
}
