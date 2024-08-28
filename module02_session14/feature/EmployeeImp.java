package module02_session14.feature;

import module02_session14.bussiness.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeImp implements  IEmployeeFeature
{
    public static List<Employee> employees = new ArrayList<Employee>();
    @Override
    public void addOrUpdate(Employee employee) {
        int indexCheck = findIndexbyid(employee.getEmployeeId());
        if (indexCheck == -1)
        {
            // chức năng thêm mới
            employees.add(employee);
        }
        else
        {
            // chức năng cập nhật
            employees.set(indexCheck, employee);
        }
    }

    @Override
    public void delete(String id) {

        employees.remove(findIndexbyid(id));

    }

    @Override
    public int findIndexbyid(String id) {
        return employees.stream().map(Employee::getEmployeeId).toList().indexOf(id);
    }
}
