package module02_session14.feature;

import module02_session14.bussiness.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DeparmentImp  implements IDepartmentFeature{

    public static  List<Department> departments = new ArrayList<Department>();



    @Override
    public void addOrUpdate(Department department) {
           int indexCheck = findIndexbyid(department.getDepartmentId());

           if(indexCheck == -1){
               departments.add(department);
           }else {
               departments.set(indexCheck,department);
           }

    }

    @Override
    public void delete(String id) {
          departments.remove(findIndexbyid(id));

    }

    @Override
    public int findIndexbyid(String id) {
        return  departments.stream().map(department -> department.getDepartmentId()).toList().indexOf(id);
    }
}
