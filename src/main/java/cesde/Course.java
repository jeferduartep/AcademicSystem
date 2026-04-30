package cesde;

public class Course {

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

    public int getId() { return id; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public String getStatus() { return status; }
    public Program getProgram() { return program; }
    public Teacher getTeacher() { return teacher; }

    public void setName(String name) { this.name = name; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setStatus(String status) { this.status = status; }
    public void setProgram(Program program) { this.program = program; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public void assignTeacher(Teacher t) {
        this.teacher = t;
    }

    @Override
    public String toString() {
        return "Curso: " + name + " | Créditos: " + credits + " | Docente: "
                + (teacher != null ? teacher.getName() : "Sin asignar") + " | Estado: " + status;
    }
}