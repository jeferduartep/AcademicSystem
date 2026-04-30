package cesde;

public class Program {

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

    public int getId() { return id; }
    public String getName() { return name; }
    public int getTotalCredits() { return totalCredits; }
    public String getDegreeTitle() { return degreeTitle; }
    public String getStatus() { return status; }
    public School getSchool() { return school; }

    public void setName(String name) { this.name = name; }
    public void setTotalCredits(int totalCredits) { this.totalCredits = totalCredits; }
    public void setDegreeTitle(String degreeTitle) { this.degreeTitle = degreeTitle; }
    public void setStatus(String status) { this.status = status; }
    public void setSchool(School school) { this.school = school; }

    @Override
    public String toString() {
        return "Programa: " + name + " | Título: " + degreeTitle
                + " | Créditos: " + totalCredits + " | Estado: " + status;
    }
}