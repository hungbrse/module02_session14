package module02_session14.Service;

import module02_session14.bussiness.entity.Employee;
import module02_session14.feature.DeparmentImp;
import module02_session14.feature.EmployeeImp;
import module02_session14.feature.IEmployeeFeature;

import java.util.List;
import java.util.Scanner;


public class EmployeeService {
     IEmployeeFeature employeeFeature = new EmployeeImp();


     public  void employeeController(Scanner sc) {

          boolean isLoop = true;
          do {
               System.out.println("1. Hiển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)");
               System.out.println("2. Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)");
               System.out.println("3. Thêm mới nhân viên");
               System.out.println("4. Chỉnh sửa thông tin nhân viên");
               System.out.println("5. Xóa nhân viên");
               System.out.println("6. Thống kê số lượng nhân viên trung bình của mỗi phòng");
               System.out.println("7. Tìm ra 5 phòng có số lượng nhân viên đông nhất");
               System.out.println("8. Tìm ra người quản lý nhiều nhân viên nhất");
               System.out.println("9. Tìm ra 5 nhân viên có tuổi cao nhất công ty");
               System.out.println("10. Tìm ra 5 nhân viên hưởng lương cao nhất");
               System.out.println("11. thoát");

               int choice = Integer.parseInt(sc.nextLine());
               switch (choice) {
                    case 1:
                         showEmployee();
                         break;
                    case 2:
                         showEmployById(sc);
                         break;
                    case 3:
                         addEmploy(sc);
                         break;
                    case 4:
                         editEmploy(sc);
                         break;
                    case 5:
                         deleteEmployById(sc);
                         break;
                    case 11:
                         isLoop = false;
                         break;

               }

          }while (isLoop);

     }

     public void addEmploy(Scanner sc) {
          System.out.println("nhập số lượng nhân viên muốn add");
          int n = Integer.parseInt(sc.nextLine());
          for (int i = 0; i < n; i++) {
               Employee emp = new Employee();
               emp.inputEmployee(sc);
               EmployeeImp.employees.add(emp);
          }
     }

     public void showEmployee() {
          if (EmployeeImp.employees.isEmpty()) {
               System.err.println("nhân viên trống ");
          }else  {
               EmployeeImp.employees.forEach(item -> item.displayData());
          }
     }
     public void showEmployById(Scanner sc) {
          System.out.println("hãy nhập id sách phòng ban");
          String id = sc.nextLine();
          List<Employee> employees = EmployeeImp.employees.stream().filter(item -> item.getEmployeeId().equals(id)).toList();
          employees.forEach(item -> item.displayData());

     }

     public  void editEmploy(Scanner sc) {
          System.out.println("nhập id nhân viên bạn muốn sửa : ");
          do {
               String updataName = sc.nextLine();
               int updataIndex = employeeFeature.findIndexbyid(updataName);

               if (updataIndex == -1) {
                    System.err.println("không tồn tại id " + updataName);
               }else  {
                    Employee emp = EmployeeImp.employees.get(updataIndex);
                    emp.inputUpdata(sc);  // Cập nhật thông tin nhân viên từ input
                    employeeFeature.addOrUpdate(emp);  // Cập nhật lại trong danh sách
                    break; // Thoát khỏi vòng lặp sau khi hoàn thành việc chỉnh sửa
               }
          }while (true);
     }

     public  void deleteEmployById(Scanner sc) {
          System.out.println("nhập id muốn delete");
          do {
               String id = sc.nextLine();
               int index = employeeFeature.findIndexbyid(id);
               if (index != -1) {
                    employeeFeature.delete(id); // Xóa nhân viên
                    System.out.println("Xóa thành công nhân viên với ID: " + id);
                    break; // Thoát khỏi vòng lặp sau khi xóa thành công
               } else {
                    System.out.println("Không tồn tại ID: " + id);
               }

          }while (true);
     }

}
