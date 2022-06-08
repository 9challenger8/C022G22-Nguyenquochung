package repository.icustomer;

import model.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> selectAllCustomerType();
    CustomerType selectById( int id) throws SQLException;
}
