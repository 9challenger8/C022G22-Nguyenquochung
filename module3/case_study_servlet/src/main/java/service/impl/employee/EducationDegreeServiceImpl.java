package service.impl.employee;

import model.employee.EducationDegree;
import repository.iemployee.IEducationDegreeRepository;
import repository.impl.employee.EducationDegreeRepositoryImpl;
import service.iemployee.IEducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    private IEducationDegreeRepository iEducationDegreeRepository=new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> selectAll() {
        return iEducationDegreeRepository.selectAll();
    }
}
