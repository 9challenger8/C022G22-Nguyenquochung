package service.impl.employee;

import model.employee.Position;
import repository.iemployee.IPositionRepository;
import repository.impl.employee.PositionRepositoryImpl;
import service.iemployee.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository iPositionRepository=new PositionRepositoryImpl();
    @Override
    public List<Position> selectAll() {
        return iPositionRepository.selectAll();
    }
}
