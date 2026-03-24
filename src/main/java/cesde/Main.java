package cesde;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        School school = new School(1, "CESDE", "Carlos Gómez", "Medellín", "info@cesde.edu", "ACTIVO");

        Program program = new Program(1, "Desarrollo de Software", 120, "Tecnólogo", "ACTIVO", school);

        Teacher teacher = new Teacher(1, "Juan", "Pérez", "Java", "juan@cesde.edu", "ACTIVO");

        Student student = new Student(1, "Ana", "López", "ana@correo.com", "123456", "ACTIVO");

        ClassRoom classroom = new ClassRoom(1, "A101", 1, 30, RoomType.MEDIANO, "DISPONIBLE");

        Course course = new Course(1, "Programación Java", 4, "ACTIVO", program, teacher);

        Enrollment enrollment = new Enrollment(1, student, course, LocalDate.now(), "2026-1", 0);

        Schedule schedule = new Schedule(1, course, teacher, classroom, DayOfWeekEnum.LUNES, LocalTime.of(8, 0));

        System.out.println("\n= DATOS INICIALES =");

        school.getSchoolDetails();
        program.getProgramDetails();
        teacher.getTeacherDetails();
        student.getStudentDetails();
        classroom.getClassRoomDetails();
        course.getCourseDetails();
        enrollment.getEnrollmentDetails();
        schedule.getScheduleDetails();

        System.out.println("\n= FUNCIONALIDADES =");

        program.changeStatus("INACTIVO");

        Teacher newTeacher = new Teacher(2, "Laura", "Martínez", "Spring Boot", "laura@cesde.edu", "ACTIVO");
        course.assignTeacher(newTeacher);

        enrollment.updateGrade(4.5);

        schedule.changeTime(LocalTime.of(10, 0));

        if (classroom.isAvailable()) {
            System.out.println("El salon está disponible.");
        }

        System.out.println("\n= DATOS ACTUALIZADOS =");

        program.getProgramDetails();
        course.getCourseDetails();
        enrollment.getEnrollmentDetails();
        schedule.getScheduleDetails();

        System.out.println("\n= SISTEMA FINALIZADO =");
    }
}
