package cesde;

import cesde.view.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentView   studentView   = new StudentView();
        TeacherView   teacherView   = new TeacherView();
        CourseView    courseView    = new CourseView();
        ClassRoomView classRoomView = new ClassRoomView();
        EnrollmentView enrollmentView = new EnrollmentView();
        ScheduleView  scheduleView  = new ScheduleView();
        ProgramView   programView   = new ProgramView();
        SchoolView    schoolView    = new SchoolView();

        int option;

        do {
            System.out.println("\n══════════ MENÚ PRINCIPAL ══════════");
            System.out.println("║  1. Gestión de Estudiantes       ║");
            System.out.println("║  2. Gestión de Docentes          ║");
            System.out.println("║  3. Gestión de Cursos            ║");
            System.out.println("║  4. Gestión de Salones           ║");
            System.out.println("║  5. Gestión de Matrículas        ║");
            System.out.println("║  6. Gestión de Horarios          ║");
            System.out.println("║  7. Gestión de Programas         ║");
            System.out.println("║  8. Gestión de Escuelas          ║");
            System.out.println("║  0. Salir                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Opción: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> studentView.showMenu();
                case 2 -> teacherView.showMenu();
                case 3 -> courseView.showMenu();
                case 4 -> classRoomView.showMenu();
                case 5 -> enrollmentView.showMenu();
                case 6 -> scheduleView.showMenu();
                case 7 -> programView.showMenu();
                case 8 -> schoolView.showMenu();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (option != 0);
    }
}