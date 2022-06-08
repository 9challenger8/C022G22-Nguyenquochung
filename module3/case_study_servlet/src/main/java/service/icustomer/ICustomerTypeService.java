package service.icustomer;

import model.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> selectAllCustomerType();
    CustomerType selectById(int id) throws SQLException;
}
