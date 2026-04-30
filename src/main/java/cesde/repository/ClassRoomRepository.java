package cesde.repository;

import cesde.ClassRoom;
import java.util.ArrayList;

public class ClassRoomRepository {

    private ArrayList<ClassRoom> classRooms = new ArrayList<>();
    private int nextId = 1;

    public ClassRoom save(ClassRoom classRoom) {
        classRooms.add(classRoom);
        return classRoom;
    }

    public ClassRoom findById(int id) {
        for (ClassRoom cr : classRooms) {
            if (cr.getId() == id) return cr;
        }
        return null;
    }

    public ArrayList<ClassRoom> findAll() {
        return classRooms;
    }

    public boolean update(int id, ClassRoom updated) {
        for (int i = 0; i < classRooms.size(); i++) {
            if (classRooms.get(i).getId() == id) {
                classRooms.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < classRooms.size(); i++) {
            if (classRooms.get(i).getId() == id) {
                classRooms.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}