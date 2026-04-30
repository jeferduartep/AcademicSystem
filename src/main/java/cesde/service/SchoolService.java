package cesde.service;

import cesde.School;
import cesde.repository.SchoolRepository;
import java.util.ArrayList;

public class SchoolService {

    private SchoolRepository repository = new SchoolRepository();


    public School create(String name, String director, String address, String email, String status) {
        int id = repository.generateId();
        School school = new School(id, name, director, address, email, status);
        repository.save(school);
        System.out.println("✔ Escuela creada: " + school);
        return school;
    }


    public School getById(int id) {
        School school = repository.findById(id);
        if (school == null) {
            System.out.println("✘ Escuela con ID " + id + " no encontrada.");
        }
        return school;
    }


    public ArrayList<School> getAll() {
        ArrayList<School> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay escuelas registradas.");
        }
        return list;
    }


    public boolean update(int id, String name, String director, String address, String email, String status) {
        School existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: escuela ID " + id + " no existe.");
            return false;
        }
        School updated = new School(id, name, director, address, email, status);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Escuela actualizada: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Escuela ID " + id + " eliminada.");
        } else {
            System.out.println("✘ No se encontró escuela ID " + id + " para eliminar.");
        }
        return result;
    }
}