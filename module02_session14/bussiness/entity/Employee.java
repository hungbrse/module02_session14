package module02_session14.bussiness.entity;

import module02_session14.feature.DeparmentImp;
import module02_session14.feature.EmployeeImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class Employee {
    private String employeeId ;
    private String employeeName ;
    private LocalDate birthDay;
    private double salary;
    private boolean sex;
    private Employee manager;
    private Department department;
    public Employee() {}

    public Employee(String employeeId, Department department, Employee manager, double salary, boolean sex, String employeeName, LocalDate birthDay) {
        this.employeeId = employeeId;
        this.department = department;
        this.manager = manager;
        this.salary = salary;
        this.sex = sex;
        this.employeeName = employeeName;
        this.birthDay = birthDay;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {

    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


     public  void  inputEmployee(Scanner sc){
        this.employeeId = inputEmployeeId(sc);
        this.employeeName = inputEmployeeName(sc);
        this.birthDay = inputBirthDay(sc);
        this.sex = inputSex(sc);
        this.salary = inputSalary(sc);
        this.manager = inputManager(sc);
        this.department = inputEmployeeDepartment(sc);
     }

    private Employee inputManager(Scanner sc) {

        EmployeeImp.employees.forEach(item -> {
            System.out.printf("[ id :%s | Name : %s ]\n",
                    item.getEmployeeId(),
                    item.getEmployeeName()
            );
        });
        System.out.println("nhập tên manager null or điền tên ");

        do {
            String managerId = sc.nextLine();
            if (managerId.isBlank()) {
                return null;
            } else {
                Optional<Employee> optionalEmployee = EmployeeImp.employees.stream().filter(item -> item.getEmployeeId().equals(managerId)).findFirst();
                if (optionalEmployee.isPresent()) {
                    return optionalEmployee.get();
                } else {
                    System.err.println("không tồn tại mã quản lý ");
                }
            }
        } while (true) ;
    }
    private Department inputEmployeeDepartment(Scanner sc) {
        // show department
        DeparmentImp.departments.forEach(item ->
        {
            System.out.printf("[ ID: %s | Name: %s ]\n", item.getDepartmentId(), item.getDepartmentName());
        });

        System.out.println("hãy chọn phòng ban nhân viên ");

        do {
            String depId = sc.nextLine();
            if (depId.isBlank()) {
                System.err.println("đừng để trống ");
            } else {
                Optional<Department> optionalDepartment = DeparmentImp.departments.stream()
                        .filter(item -> item.getDepartmentId().equals(depId))
                        .findFirst();

                if (optionalDepartment.isPresent()) {
                    Department department = optionalDepartment.get();

                    if (this.department != null) {
                        // Nếu nhân viên đã có department, giảm số lượng thành viên của phòng ban cũ
                        this.department.setTotalMembers(this.department.getTotalMembers() - 1);
                    }
                    // Cập nhật department mới cho nhân viên và tăng số lượng thành viên của phòng ban mới
                    this.department = department;
                    this.department.setTotalMembers(this.department.getTotalMembers() + 1);
                    return this.department;
                } else {
                    System.out.println("không tồn tại id " + depId);
                }
            }

        } while (true);
    }


    private double inputSalary(Scanner sc) {
        System.out.println("nhập số lương ");
        do {
            double salary = Double.parseDouble(sc.nextLine());

            if (salary >= 0) {
                return salary;
            }else  {
                System.err.println("hãy nhập lại salary");
            }

        }while (true);
    }

    private boolean inputSex(Scanner sc) {
        System.out.println("nhập giới tính nhân viên");
        do {
            String sex = sc.nextLine();
            if (sex.isBlank()) {
                System.err.println("hãy nhập giới tính true or false");
            }else  {
                if (sex.equals("true") || sex.equals("false")) {
                    return Boolean.parseBoolean(sex);
                } else  {
                    System.err.println("hãy nhập giới tính true or false");
                }
            }

        }while (true);
    }

    private LocalDate inputBirthDay(Scanner sc) {
        System.out.println("nhập ngày sênh");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            String birthday = sc.nextLine();

            if (birthday.isBlank()) {
                System.out.println("đừng để trống ");
            } else  {
                return LocalDate.parse(birthday,formatter);
            }

        }while (true);
    }

    private String inputEmployeeName(Scanner sc) {
        System.out.println("nhận tên nhân viên" );

        do {
            String employeeName = sc.nextLine();
            if (employeeName.isBlank()) {
                System.err.println("đừng để tên trống ");
            }else {
                return  employeeName;
            }

        }while (true);
    }

    private String inputEmployeeId(Scanner sc) {
        System.out.println("hãy nhập id nhân viên ");
        do {
            String employeeId = sc.nextLine();
            if (employeeId.isBlank()) {
                System.err.println("tên nhân viên trống huhu");
            }else {
                if (employeeId.matches("^E\\w{3}$")) {
                    boolean isExist = EmployeeImp.employees.stream().anyMatch(item -> item.getEmployeeId().equals(employeeId));

                    if (isExist) {
                        System.out.println("mã id tồn tại rồi m ");
                    }else  {
                        return employeeId;
                    }

                }else {
                    System.out.println("nhập không đúng định dạng ");
                }

            }

        }while (true);
    }

    public void inputUpdata(Scanner sc) {
        this.employeeName = inputEmployeeName(sc);
        this.birthDay = inputBirthDay(sc);
        this.sex = inputSex(sc);
        this.salary = inputSalary(sc);
        this.manager = inputManager(sc);
        this.department = inputEmployeeDepartment(sc);

    }
    public void displayData() {
        System.out.printf("[ ID: %s | Name: %s | dob: %s | Sex: %s | Salary: %f | Manager: %s | Dep: %s ]\n", this.employeeId, this.employeeName, this.birthDay.toString(), this.sex ? "Nam" : "Nữ", this.salary, this.manager != null ? this.manager.getEmployeeName() : "None", this.department.getDepartmentName());
    }

}
