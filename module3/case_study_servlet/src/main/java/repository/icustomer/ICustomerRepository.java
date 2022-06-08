package repository.icustomer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
     void insertCustomer(Customer customer);
     List<Customer> selectAllCustomers();
     boolean deleteUser(int id) throws SQLException;
     boolean updateUser(Customer customer) throws SQLException;
     List<Customer> searchByName(String name) throws SQLException;
     Customer selectUserById(int id) throws SQLException;
}
