package service.impl.customer;

import model.customer.Customer;
import repository.icustomer.ICustomerRepository;
import repository.impl.customer.CustomerRepositoryImpl;
import service.icustomer.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository iCustomerRepository=new CustomerRepositoryImpl();
    @Override
    public void insertCustomer(Customer customer) {

        iCustomerRepository.insertCustomer(customer);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> listCustomer= iCustomerRepository.selectAllCustomers();
        return listCustomer;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        rowDelete=iCustomerRepository.deleteUser(id);
        return rowDelete;
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {
        boolean rowUpdate;
        rowUpdate=iCustomerRepository.updateUser(customer);
        return rowUpdate;
    }

    @Override
    public List<Customer> searchByName(String name, String idCustomerType) throws SQLException {
        return iCustomerRepository.searchByName(name,idCustomerType);
    }

    @Override
    public Customer selectUserById(int id) throws SQLException {
        return iCustomerRepository.selectUserById(id);
    }
}
