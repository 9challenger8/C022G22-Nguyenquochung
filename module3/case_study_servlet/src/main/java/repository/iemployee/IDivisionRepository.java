package repository.iemployee;

import model.employee.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> selectAll();
}
