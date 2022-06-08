package service.impl.employee;

import model.employee.Employee;
import repository.iemployee.IEmployeeRepository;
import repository.impl.employee.EmployeeRepositoryImpl;
import service.iemployee.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository= new EmployeeRepositoryImpl();
    @Override
    public List<Employee> selectAllEmployee() {
        return iEmployeeRepository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDelete;
        rowDelete= iEmployeeRepository.deleteEmployee(id);
        return rowDelete;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdate;
        rowUpdate=iEmployeeRepository.updateEmployee(employee);
        return rowUpdate;
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        return iEmployeeRepository.searchByName(name);
    }

    @Override
    public Employee selectEmployeeById(int id) throws SQLException {
        return iEmployeeRepository.selectEmployeeById(id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        iEmployeeRepository.insertCustomer(employee);
    }
}
