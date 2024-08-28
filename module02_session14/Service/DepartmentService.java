package module02_session14.Service;

import module02_session14.bussiness.entity.Department;
import module02_session14.bussiness.entity.Employee;
import module02_session14.feature.DeparmentImp;
import module02_session14.feature.EmployeeImp;
import module02_session14.feature.IDepartmentFeature;

import java.util.List;
import java.util.Scanner;

public class DepartmentService {

    IDepartmentFeature departmentFeature = new DeparmentImp();

    public void DepartmentServiceController(Scanner sc) {

        boolean isLoop = true;
        do {
            System.out.println("""
					      ======================= MENU =======================
					         1. Hiển thị danh sách phòng ban
					         2. Thêm mới phòng ban
					         3. Sửa tên phòng ban
					         4. Hiển thị nhân viên theo mã phòng ban
					         5. Xóa phòng ban
					         6. Quay lại
					      ====================================================
					      Lựa chọn đê:
					  """);
            int choice = Integer.parseInt(sc.nextLine());
          switch (choice) {
              case 1:
                  showAllDepartments();
                  break;
                  case 2:
                      addNewDeparment(sc);
                      break;
                      case 3:
                          editDepartmentName(sc);
                          break;
                          case 4:
                              showEmploybyDep(sc);
                              break;
                              case 5:
                                  deleteDepartment(sc);
                                  break;
                                  case 6:
                                      isLoop = false;
                                      break;
              default:
                  System.err.println("hãy nhập từ 1 đến 6 ");
          }

        }while (isLoop);

    }

    private void addNewDeparment(Scanner sc ) {
        System.out.println("bạn muốn thêm bao nhiêu phòng :");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Department department = new Department();
            department.inputDepartment(sc);
            DeparmentImp.departments.add(department);
        }
    }

      private void showAllDepartments() {
        if (DeparmentImp.departments.isEmpty()) {
            System.err.println("danh sách trống : ");
            return;
        }else  {
            DeparmentImp.departments.forEach(Department::displayDepartment);
        }

      }
      private  void  editDepartmentName(Scanner sc) {
          System.out.println("nhập id department muốn sửa tên ");
          String id = sc.nextLine();
           int indexUpdata = departmentFeature.findIndexbyid(id);

           if (indexUpdata == - 1) {
               System.err.println("Id không tồn tại ");
           } else  {
              Department oldDepartment = DeparmentImp.departments.get(indexUpdata);
              oldDepartment.setDepartmentName(oldDepartment.inputNameUpdata(sc));
           }

      }
      private void  showEmploybyDep (Scanner sc) {
          System.out.println("hãy nhập danh sách phòng ban");
           String depId = sc.nextLine();
          List<Employee> employees = EmployeeImp.employees.stream().filter(item -> item.getEmployeeId().equals(depId)).toList();
        if (employees.isEmpty()) {
            System.out.println("phòng ban không có nhân viên ");
            return;
        }
         employees.forEach(item -> item.displayData());
      }
      private  void deleteDepartment(Scanner sc) {
          System.out.println("nhập id muốn xóa ");
          String deleteId = sc.nextLine();

          boolean isExist = DeparmentImp.departments.stream().anyMatch(item -> item.getDepartmentId().equals(deleteId));

          if (isExist) {
               boolean hasEmp = EmployeeImp.employees.stream().anyMatch(item -> item.getEmployeeId().equals(deleteId));
                if (hasEmp) {
                    System.out.println("phòng ban không thể xóa");
                }  else {
                    departmentFeature.delete(deleteId);
                }
          } else  {
              System.out.println("không tồn tại id " + deleteId);
          }

      }
}
