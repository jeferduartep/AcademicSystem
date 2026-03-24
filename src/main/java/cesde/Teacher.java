package cesde;

import java.util.Scanner;

public class Teacher {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String name;
    private String lastname;
    private String speciality;
    private String email;
    private String status;

    public Teacher(int id, String name, String lastname, String speciality, String email, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.speciality = speciality;
        this.email = email;
        this.status = status;
    }

    public void createTeacher() {
        System.out.print("Nombre: "); name = sc.nextLine();
        System.out.print("Apellido: "); lastname = sc.nextLine();
        System.out.print("Especialidad: "); speciality = sc.nextLine();
        System.out.println("Docente creado.");
    }

    public void getTeacherDetails() {
        System.out.println("= DOCENTE =");
        System.out.println(name + " " + lastname);
    }

    public void assignSpeciality(String newSpeciality) {
        speciality = newSpeciality;
    }
}