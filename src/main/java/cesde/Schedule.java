package cesde;

import java.time.LocalTime;
import java.util.Scanner;

public class Schedule {

    Scanner sc = new Scanner(System.in);

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

    public void createSchedule(Course c, Teacher t, ClassRoom cr) {
        course = c;
        teacher = t;
        classroom = cr;
        startTime = LocalTime.now();
        System.out.println("Horario asignado.");
    }

    public void getScheduleDetails() {
        System.out.println("= HORARIO =");
        System.out.println(course + " | Salon de clase: " + classroom);
    }

    public void changeTime(LocalTime newTime) {
        startTime = newTime;
    }
}