package cesde;

import java.time.LocalDate;

public class Enrollment {

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

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public String getSemester() { return semester; }
    public double getNotes() { return notes; }

    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setNotes(double notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Matrícula ID:" + id + " | Estudiante: " + (student != null ? student.getName() : "?")
                + " | Curso: " + (course != null ? course.getName() : "?")
                + " | Semestre: " + semester + " | Nota: " + notes;
    }
}