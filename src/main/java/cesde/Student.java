package cesde;

public class Student {

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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public String getDocumentNumber() { return documentNumber; }
    public String getStatus() { return status; }

    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Estudiante: " + name + " " + lastname + " | Doc: " + documentNumber + " | Estado: " + status;
    }
}