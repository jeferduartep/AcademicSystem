package cesde;

public class School {

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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDirector() { return director; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }

    public void setName(String name) { this.name = name; }
    public void setDirector(String director) { this.director = director; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Escuela: " + name + " | Director: " + director + " | Estado: " + status;
    }
}