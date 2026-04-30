package cesde.repository;

import cesde.Schedule;
import java.util.ArrayList;

public class ScheduleRepository {

    private ArrayList<Schedule> schedules = new ArrayList<>();
    private int nextId = 1;

    public Schedule save(Schedule schedule) {
        schedules.add(schedule);                        // .add()
        return schedule;
    }

    public Schedule findById(int id) {
        for (Schedule s : schedules) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public ArrayList<Schedule> findAll() {
        return schedules;
    }

    public boolean update(int id, Schedule updated) {
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId() == id) {
                schedules.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId() == id) {
                schedules.remove(i);
                return true;
            }
        }
        return false;
    }

    public int generateId() {
        return nextId++;
    }
}