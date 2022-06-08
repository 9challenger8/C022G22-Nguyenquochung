package repository.iemployee;

import model.customer.Customer;
import model.employee.Employee;
import model.employee.Position;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAllEmployee();
    boolean deleteEmployee(int id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    List<Employee> searchByName(String name) throws SQLException;
    Employee selectEmployeeById(int id) throws SQLException;
    void insertCustomer(Employee employee);
}
