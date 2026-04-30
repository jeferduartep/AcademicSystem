package cesde;

import java.time.LocalTime;

public class Schedule {

    private int id;
    private Course course;
    private Teacher teacher;
    private ClassRoom classroom;
    private DayOfWeekEnum dayOfWeek;
    private LocalTime startTime;

    public Schedule(int id, Course course, Teacher teacher, ClassRoom classroom, DayOfWeekEnum dayOfWeek, LocalTime startTime) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
    }

    public int getId() { return id; }
    public Course getCourse() { return course; }
    public Teacher getTeacher() { return teacher; }
    public ClassRoom getClassroom() { return classroom; }
    public DayOfWeekEnum getDayOfWeek() { return dayOfWeek; }
    public LocalTime getStartTime() { return startTime; }

    public void setCourse(Course course) { this.course = course; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public void setClassroom(ClassRoom classroom) { this.classroom = classroom; }
    public void setDayOfWeek(DayOfWeekEnum dayOfWeek) { this.dayOfWeek = dayOfWeek; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    @Override
    public String toString() {
        return "Horario ID:" + id + " | Curso: " + (course != null ? course.getName() : "?")
                + " | Salon: " + (classroom != null ? classroom.getNumClassRoom() : "?")
                + " | Día: " + dayOfWeek + " | Hora: " + startTime;
    }
}