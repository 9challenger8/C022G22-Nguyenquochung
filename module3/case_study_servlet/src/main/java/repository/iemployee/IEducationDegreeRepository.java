package repository.iemployee;

import model.employee.EducationDegree;


import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> selectAll();
}
