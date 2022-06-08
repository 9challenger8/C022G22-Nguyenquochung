package service.impl.employee;

import model.employee.Division;
import repository.iemployee.IDivisionRepository;
import repository.impl.employee.DivisionRepositoryImpl;
import service.iemployee.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    private IDivisionRepository iDivisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> selectAll() {
        return iDivisionRepository.selectAll();
    }
}
