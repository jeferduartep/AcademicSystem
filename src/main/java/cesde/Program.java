package cesde;

import java.util.Scanner;

public class Program {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String name;
    private int totalCredits;
    private String degreeTitle;
    private String status;
    private School school;

    public Program(int id, String name, int totalCredits, String degreeTitle, String status, School school) {
        this.id = id;
        this.name = name;
        this.totalCredits = totalCredits;
        this.degreeTitle = degreeTitle;
        this.status = status;
        this.school = school;
    }

    public void createProgram(School schoolAsignada) {
        this.school = schoolAsignada;
        System.out.print("Nombre: "); name = sc.nextLine();
        System.out.print("Créditos: "); totalCredits = sc.nextInt();
        sc.nextLine();
        System.out.print("Título: "); degreeTitle = sc.nextLine();
        System.out.println("Programa creado.");
    }

    public void getProgramDetails() {
        System.out.println("= PROGRAMA =");
        System.out.println(name + " | Escuela: " + school);
    }

    public void changeStatus(String newStatus) {
        status = newStatus;
    }
}