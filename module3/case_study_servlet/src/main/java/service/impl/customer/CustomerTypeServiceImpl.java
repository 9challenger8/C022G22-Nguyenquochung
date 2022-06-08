package service.impl.customer;

import model.customer.CustomerType;
import repository.icustomer.ICustomerTypeRepository;
import repository.impl.customer.CustomerTypeRepositoryImpl;
import service.icustomer.ICustomerTypeService;

import java.sql.SQLException;
import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    ICustomerTypeRepository iCustomerTypeRepository=new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> list=iCustomerTypeRepository.selectAllCustomerType();
        return list;
    }

    @Override
    public CustomerType selectById(int id) throws SQLException {
        return iCustomerTypeRepository.selectById(id);
    }
}
