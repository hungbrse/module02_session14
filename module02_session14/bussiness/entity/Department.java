package module02_session14.bussiness.entity;

import module02_session14.feature.DeparmentImp;

import java.util.Scanner;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {
    }

    public Department(int totalMembers, String departmentName, String departmentId) {
        this.totalMembers = totalMembers;
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
    public void inputDepartment(Scanner sc) {
        this.departmentId = inputDepartmentId(sc);
        this.departmentName = inputDepartmentName(sc);
        this.totalMembers = 0;

    }

    private String inputDepartmentName(Scanner sc) {
        System.out.println("nhập tên phòng ban : ");
           do {
               String depName = sc.nextLine();
               if (depName.isBlank()) {
                   System.err.println("đừng để trống ! ");
               } else  {
                  return depName;
               }

           }while (true);
    }

    private String inputDepartmentId(Scanner sc) {

        System.out.println("hãy nhập tên Department Id :");

        do {
          String departmentId = sc.nextLine();
                if (departmentId.isBlank()) {
                    System.err.println("đừng để trống ! ");
                }else  {
                    if (departmentId.matches("^D\\w{3}$")) {
                  boolean isExist = DeparmentImp.departments.stream().anyMatch(item -> item.getDepartmentId().equals(departmentId));

                  if (isExist) {
                      System.err.println("tên phòng ban đã tồn tại" );
                  }else {
                      return  departmentId;
                  }
                    }else {
                        System.err.println("Id khong phù hợp");
                    }
                }
        }while (true);

    }

public String inputNameUpdata(Scanner sc) {
    System.out.println("tên cũ là :" +this.departmentName);
    System.out.println("hãy nhập tên mới :");
      do {
      String updataName = sc.nextLine();

      if (updataName.isBlank()) {
          System.err.println("đừng để trống ! ");
      }else  {
          if (updataName.equals(this.departmentName)) {
              return updataName;
          }else {
            boolean isExist =DeparmentImp.departments.stream().anyMatch(item -> item.getDepartmentId().equals(updataName));
            if (isExist) {
                System.out.println("tên phòng ban đã tồn tại : ");
            }else {
            return updataName;
            }
          }
      }
      }while (true);
}
    public void displayDepartment() {


        System.out.printf("[ Department Id : %s | DepartmentName : %s | totalMembers : %d ]\n",
                departmentId,
                departmentName,
                totalMembers
        );


    }
}
