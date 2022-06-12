package repository.impl.customer;

import model.customer.Customer;
import repository.icustomer.ICustomerRepository;
import repository.impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    public static final String SELECT_ALL_CUSTOMER = "select * from khach_hang";
    private final BaseRepository baseRepository = new BaseRepository();

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into khach_hang (ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) " +
                                                                                     " values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getNumberPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> listCustomer = new ArrayList<>();
        Connection connection = baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name=rs.getString(2);
                String birthday= rs.getString(3);
                Integer gender=rs.getInt(4);
                String idCard=rs.getString(5);
                String numberPhone=rs.getString(6);
                String email=rs.getString(7);
                String address=rs.getString(8);
                Integer typeId=rs.getInt(9);
                Customer customer=new Customer(id,name,birthday,gender,idCard,numberPhone,email,address,typeId);
                listCustomer.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCustomer;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement("delete from khach_hang where ma_khach_hang = ?;");
            preparedStatement.setInt(1,id);
            rowDelete= preparedStatement.executeUpdate()>0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement= connection.prepareStatement("update khach_hang set ho_ten= ?,ngay_sinh= ?,gioi_tinh= ?,so_cmnd= ?,so_dien_thoai=?,email= ?,dia_chi= ?," +
                    " ma_loai_khach=? where ma_khach_hang=? ;");
            System.out.println(customer.getId());
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getNumberPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getTypeId());
            preparedStatement.setInt(9, customer.getId());
            System.out.println(customer.getTypeId());
            System.out.println(customer.getId());
            rowUpdate= preparedStatement.executeUpdate() >0;
        }
        return rowUpdate;
    }

    @Override
    public List<Customer> searchByName(String name,String idCustomerType) throws SQLException {
        List<Customer> listCustomer=new ArrayList<>();
        try(Connection connection=baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement(" select * from khach_hang where ho_ten like ? and ma_loai_khach like ? ;" );

            preparedStatement.setString(1, '%'+ name + '%');
            preparedStatement.setString(2, '%'+ idCustomerType+ '%');
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name1=rs.getString(2);
                String birthday= rs.getString(3);
                Integer gender=rs.getInt(4);
                String idCard=rs.getString(5);
                String numberPhone=rs.getString(6);
                String email=rs.getString(7);
                String address=rs.getString(8);
                Integer typeId=rs.getInt(9);
                listCustomer.add(new Customer(id,name1,birthday,gender,idCard,numberPhone,email,address,typeId));
            }
        }
        return listCustomer;
    }

    @Override
    public Customer selectUserById(int id) throws SQLException {
        Customer customer=null;
        try(Connection connection=baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from khach_hang where ma_khach_hang=? ");
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while ( rs.next()){
                String name=rs.getString(2);
                String birthday= rs.getString(3);
                Integer gender=rs.getInt(4);
                String idCard=rs.getString(5);
                String numberPhone=rs.getString(6);
                String email=rs.getString(7);
                String address=rs.getString(8);
                Integer typeId=rs.getInt(9);
                customer= new Customer(id,name,birthday,gender,idCard,numberPhone,email,address,typeId);
            }
        }
        return customer;
    }
}
