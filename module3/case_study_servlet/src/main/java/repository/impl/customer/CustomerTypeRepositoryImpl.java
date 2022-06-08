package repository.impl.customer;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.icustomer.ICustomerTypeRepository;
import repository.impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    BaseRepository baseRepository=new BaseRepository();
    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> listCustomerType= new ArrayList<>();
        Connection connection=baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from loai_khach");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id= resultSet.getInt(1);
                String name=resultSet.getString(2);
                CustomerType customerType=new CustomerType(id,name);
                listCustomerType.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCustomerType;
    }

    @Override
    public CustomerType selectById(int id) throws SQLException {
        CustomerType customerType=null;
        try(Connection connection=baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from loai_khach where ma_loai_khach=? ");
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while ( rs.next()){
                String name=rs.getString(2);
                customerType= new CustomerType(id,name);
            }
        }
        return customerType;
    }
}
