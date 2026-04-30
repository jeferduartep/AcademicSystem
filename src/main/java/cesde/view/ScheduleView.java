package cesde.view;

import cesde.ClassRoom;
import cesde.Course;
import cesde.DayOfWeekEnum;
import cesde.Schedule;
import cesde.Teacher;
import cesde.service.ClassRoomService;
import cesde.service.CourseService;
import cesde.service.ScheduleService;
import cesde.service.TeacherService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ScheduleView {

    private ScheduleService service    = new ScheduleService();
    private CourseService cService     = new CourseService();
    private TeacherService tService    = new TeacherService();
    private ClassRoomService crService = new ClassRoomService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n═════════ REGISTRAR HORARIO ════════");


        System.out.print("ID curso   : "); int courseId = Integer.parseInt(sc.nextLine());
        System.out.print("ID docente : "); int teacherId = Integer.parseInt(sc.nextLine());
        System.out.print("ID salón   : "); int classRoomId = Integer.parseInt(sc.nextLine());
        System.out.println("Día (LUNES/MARTES/MIERCOLES/JUEVES/VIERNES/SABADOS): ");
        System.out.print("Día        : "); DayOfWeekEnum day = DayOfWeekEnum.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Hora (HH:MM): "); LocalTime time = LocalTime.parse(sc.nextLine());

        Course course     = cService.getById(courseId);
        Teacher teacher   = tService.getById(teacherId);
        ClassRoom classRoom = crService.getById(classRoomId);

        if (course == null || teacher == null || classRoom == null) {
            System.out.println("✘ Curso, docente o salón no encontrado.");
            return;
        }

        service.create(course, teacher, classRoom, day, time);
    }


    public void search() {
        System.out.println("\n══════════ BUSCAR HORARIO ═════════");

        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        Schedule s = service.getById(id);
        if (s != null) {
            System.out.println("Resultado → " + s);
        }
    }


    public void searchAll() {
        System.out.println("\n══════════ TODOS LOS HORARIOS ══════════");

        ArrayList<Schedule> list = service.getAll();
        for (Schedule s : list) {                       // .for mejorado sobre ArrayList
            System.out.println("  • " + s);
        }
    }


    public void update() {
        System.out.println("\n══════════ ACTUALIZAR HORARIO ══════════");

        System.out.print("ID a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        Schedule existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("ID nuevo curso   : "); int courseId = Integer.parseInt(sc.nextLine());
        System.out.print("ID nuevo docente : "); int teacherId = Integer.parseInt(sc.nextLine());
        System.out.print("ID nuevo salón   : "); int classRoomId = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo día        : "); DayOfWeekEnum day = DayOfWeekEnum.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Nueva hora (HH:MM): "); LocalTime time = LocalTime.parse(sc.nextLine());

        Course course       = cService.getById(courseId);
        Teacher teacher     = tService.getById(teacherId);
        ClassRoom classRoom = crService.getById(classRoomId);

        if (course == null || teacher == null || classRoom == null) {
            System.out.println("✘ Curso, docente o salón no encontrado.");
            return;
        }

        service.update(id, course, teacher, classRoom, day, time);
    }


    public void delete() {
        System.out.println("\n══════════ ELIMINAR HORARIO ══════════");


        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {
            System.out.println("\n═════════ MÓDULO HORARIOS ══════════");
            System.out.println("║  1. Registrar horario        ║");
            System.out.println("║  2. Buscar por ID            ║");
            System.out.println("║  3. Listar todos             ║");
            System.out.println("║  4. Actualizar               ║");
            System.out.println("║  5. Eliminar                 ║");
            System.out.println("║  0. Volver                   ║");
            System.out.print("Opción: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> create();
                case 2 -> search();
                case 3 -> searchAll();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }
}