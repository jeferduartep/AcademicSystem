package cesde;

public class Teacher {

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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public String getSpeciality() { return speciality; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }

    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
    public void setEmail(String email) { this.email = email; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Docente: " + name + " " + lastname + " | Especialidad: " + speciality + " | Estado: " + status;
    }
}