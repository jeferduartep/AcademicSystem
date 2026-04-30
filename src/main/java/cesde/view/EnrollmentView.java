package cesde.view;

import cesde.Course;
import cesde.Enrollment;
import cesde.Student;
import cesde.service.CourseService;
import cesde.service.EnrollmentService;
import cesde.service.StudentService;
import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentView {

    private EnrollmentService service  = new EnrollmentService();
    private StudentService sService    = new StudentService();
    private CourseService cService     = new CourseService();
    private Scanner sc = new Scanner(System.in);


    public void create() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     REGISTRAR MATRÍCULA      ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID estudiante : "); int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("ID curso      : "); int courseId = Integer.parseInt(sc.nextLine());
        System.out.print("Semestre      : "); String semester = sc.nextLine();
        System.out.print("Nota inicial  : "); double notes = Double.parseDouble(sc.nextLine());

        Student student = sService.getById(studentId);
        Course course   = cService.getById(courseId);

        if (student == null || course == null) {
            System.out.println("✘ Estudiante o curso no encontrado.");
            return;
        }

        service.create(student, course, semester, notes);
    }


    public void search() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      BUSCAR MATRÍCULA        ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID a buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        Enrollment e = service.getById(id);
        if (e != null) {
            System.out.println("Resultado → " + e);
        }
    }


    public void searchAll() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     TODAS LAS MATRÍCULAS     ║");
        System.out.println("╚══════════════════════════════╝");

        ArrayList<Enrollment> list = service.getAll();
        for (Enrollment e : list) {                     // .for mejorado sobre ArrayList
            System.out.println("  • " + e);
        }
    }


    public void update() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     ACTUALIZAR MATRÍCULA     ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID a actualizar : ");
        int id = Integer.parseInt(sc.nextLine());

        Enrollment existing = service.getById(id);
        if (existing == null) return;

        System.out.println("Datos actuales → " + existing);
        System.out.print("ID nuevo estudiante : "); int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("ID nuevo curso      : "); int courseId = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo semestre      : "); String semester = sc.nextLine();
        System.out.print("Nueva nota          : "); double notes = Double.parseDouble(sc.nextLine());

        Student student = sService.getById(studentId);
        Course course   = cService.getById(courseId);

        if (student == null || course == null) {
            System.out.println("✘ Estudiante o curso no encontrado.");
            return;
        }

        service.update(id, student, course, semester, notes);
    }


    public void delete() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      ELIMINAR MATRÍCULA      ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("ID a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
    }


    public void showMenu() {
        int option;
        do {
            System.out.println("\n═════════ MÓDULO MATRÍCULAS ═════════");
            System.out.println("║  1. Registrar matrícula      ║");
            System.out.println("║  2. Buscar por ID            ║");
            System.out.println("║  3. Listar todas             ║");
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