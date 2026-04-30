package cesde.service;

import cesde.Program;
import cesde.School;
import cesde.repository.ProgramRepository;
import java.util.ArrayList;

public class ProgramService {

    private ProgramRepository repository = new ProgramRepository();


    public Program create(String name, int totalCredits, String degreeTitle, String status, School school) {
        int id = repository.generateId();
        Program program = new Program(id, name, totalCredits, degreeTitle, status, school);
        repository.save(program);
        System.out.println("✔ Programa creado: " + program);
        return program;
    }


    public Program getById(int id) {
        Program program = repository.findById(id);
        if (program == null) {
            System.out.println("✘ Programa con ID " + id + " no encontrado.");
        }
        return program;
    }


    public ArrayList<Program> getAll() {
        ArrayList<Program> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("✘ No hay programas registrados.");
        }
        return list;
    }


    public boolean update(int id, String name, int totalCredits, String degreeTitle, String status, School school) {
        Program existing = repository.findById(id);
        if (existing == null) {
            System.out.println("✘ No se puede actualizar: programa ID " + id + " no existe.");
            return false;
        }
        Program updated = new Program(id, name, totalCredits, degreeTitle, status, school);
        boolean result = repository.update(id, updated);
        if (result) System.out.println("✔ Programa actualizado: " + updated);
        return result;
    }


    public boolean delete(int id) {
        boolean result = repository.delete(id);
        if (result) {
            System.out.println("✔ Programa ID " + id + " eliminado.");
        } else {
            System.out.println("✘ No se encontró programa ID " + id + " para eliminar.");
        }
        return result;
    }
}