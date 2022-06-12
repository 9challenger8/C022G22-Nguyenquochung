package service.icustomer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    void insertCustomer(Customer customer);
    List<Customer> selectAllCustomers();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(Customer customer) throws SQLException;
    List<Customer> searchByName(String name,String idCustomerType) throws SQLException;
    Customer selectUserById(int id) throws SQLException;
}
