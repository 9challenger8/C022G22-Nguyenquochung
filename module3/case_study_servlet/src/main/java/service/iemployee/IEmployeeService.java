package service.iemployee;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();
    boolean deleteEmployee(int id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    List<Employee> searchByName(String name) throws SQLException;
    Employee selectEmployeeById(int id) throws SQLException;
    void insertEmployee(Employee employee);
}
