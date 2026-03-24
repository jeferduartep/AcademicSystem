package cesde;

import java.util.Scanner;

public class Student {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String name;
    private String lastname;
    private String email;
    private String documentNumber;
    private String status;

    public Student(int id, String name, String lastname, String email, String documentNumber, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.documentNumber = documentNumber;
        this.status = status;
    }

    public void createStudent() {
        System.out.print("Nombre: "); name = sc.nextLine();
        System.out.print("Documento: "); documentNumber = sc.nextLine();
        System.out.println("Estudiante creado.");
    }

    public void getStudentDetails() {
        System.out.println("= Estudiante =");
        System.out.println(name + " " + lastname);
    }

    public void deactivateStudent() {
        status = "INACTIVO";
    }
}