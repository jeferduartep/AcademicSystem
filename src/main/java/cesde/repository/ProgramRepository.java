package cesde.repository;

import cesde.Program;
import java.util.ArrayList;

public class ProgramRepository {

    private ArrayList<Program> programs = new ArrayList<>();
    private int nextId = 1;

    public Program save(Program program) {
        programs.add(program);
        return program;
    }

    public Program findById(int id) {
        for (Program p : programs) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public ArrayList<Program> findAll() {
        return programs;
    }

    public boolean update(int id, Program updated) {
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getId() == id) {
                programs.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getId() == id) {
                programs.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}