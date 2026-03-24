package cesde;

import java.time.LocalDate;
import java.util.Scanner;

public class Enrollment {

    Scanner sc = new Scanner(System.in);

    private int id;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String semester;
    private double notes;

    public Enrollment(int id, Student student, Course course, LocalDate enrollmentDate, String semester, double notes) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.semester = semester;
        this.notes = notes;
    }

    public void createEnrollment(Student s, Course c) {
        student = s;
        course = c;
        enrollmentDate = LocalDate.now();
        System.out.println("Matrícula realizada.");
    }

    public void getEnrollmentDetails() {
        System.out.println("= INSCRIPCION =");
        System.out.println(student + " -> " + course);
    }

    public void updateGrade(double newNote) {
        notes = newNote;
    }
}