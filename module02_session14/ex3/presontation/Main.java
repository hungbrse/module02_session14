package module02_session14.ex3.presontation;




import module02_session14.Service.DepartmentService;
import module02_session14.Service.EmployeeService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentService ds = new DepartmentService();
        EmployeeService es = new EmployeeService();



        boolean isLoop = true;
        do {
            System.out.println("1 . Quản trị phòng ban :");
            System.out.println("2 .Quản trị nhân viên");
            System.out.println("3 . thoát");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ds.DepartmentServiceController(sc);
                      break;
                      case 2:
                 es.employeeController(sc);

                          break;
                          case 3:
                              System.exit(0);
            }


        }while (isLoop);
    }
}
