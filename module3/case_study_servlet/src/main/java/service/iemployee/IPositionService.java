package service.iemployee;

import model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> selectAll();
}
