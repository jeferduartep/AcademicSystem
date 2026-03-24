package cesde;

import java.util.Scanner;

public class School {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String name;
    private String director;
    private String address;
    private String email;
    private String status;

    public School(int id, String name, String director, String address, String email, String status) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.address = address;
        this.email = email;
        this.status = status;
    }

    public void createSchool() {
        System.out.println("= CREAR ESCUELA =");
        System.out.print("Nombre: "); name = sc.nextLine();
        System.out.print("Director: "); director = sc.nextLine();
        System.out.print("Dirección: "); address = sc.nextLine();
        System.out.print("Email: "); email = sc.nextLine();
        System.out.print("Estado: "); status = sc.nextLine();
        System.out.println("Escuela creada.");
    }

    public void getSchoolDetails() {
        System.out.println("= Escuela =");
        System.out.println(name + " | Director: " + director);
    }

    public void activateSchool() {
        status = "ACTIVO";
    }
}
