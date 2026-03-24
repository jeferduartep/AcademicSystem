package cesde;

import java.util.Scanner;

public class Course {

    Scanner sc = new Scanner(System.in);

    private int id;
    private String name;
    private int credits;
    private String status;
    private Program program;
    private Teacher teacher;

    public Course(int id, String name, int credits, String status, Program program, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.status = status;
        this.program = program;
        this.teacher = teacher;
    }

    public void createCourse(Program programAsignado, Teacher teacherAsignado) {
        this.program = programAsignado;
        this.teacher = teacherAsignado;

        System.out.print("Nombre curso: "); name = sc.nextLine();
        System.out.print("Créditos: "); credits = sc.nextInt();
        System.out.println("Curso creado.");
    }

    public void getCourseDetails() {
        System.out.println("= CURSO =");
        System.out.println(name + " | Docente: " + teacher);
    }

    public void assignTeacher(Teacher t) {
        this.teacher = t;
    }
}
