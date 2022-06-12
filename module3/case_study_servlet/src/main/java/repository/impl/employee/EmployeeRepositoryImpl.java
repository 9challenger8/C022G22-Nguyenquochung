package repository.impl.employee;

import model.customer.Customer;
import model.employee.Employee;
import repository.iemployee.IEmployeeRepository;
import repository.impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    BaseRepository baseRepository =new BaseRepository();
    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> listEmployee = new ArrayList<>();

        try(Connection connection = baseRepository.getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do, " +
                    " ma_bo_phan from nhan_vien");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name=rs.getString(2);
                String birthday= rs.getString(3);
                String idCard=rs.getString(4);
                String salary=rs.getString(5);
                String numberPhone=rs.getString(6);
                String email=rs.getString(7);
                String address=rs.getString(8);
                Integer position=rs.getInt(9);
                Integer educationDegree=rs.getInt(10);
                Integer division=rs.getInt(11);
                Employee employee =new Employee(id,name,birthday,idCard,salary,numberPhone,email,address,position,educationDegree,division);
                listEmployee.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection= baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement("delete from nhan_vien where ma_nhan_vien = ?;");
            preparedStatement.setInt(1,id);
            rowDelete= preparedStatement.executeUpdate()>0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {

        boolean rowUpdate;
        try(Connection connection = baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement= connection.prepareStatement("update nhan_vien set ho_ten= ?,ngay_sinh= ?,so_cmnd= ?,luong=? ,so_dien_thoai=?,email= ?,dia_chi= ?," +
                    " ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=? where ma_nhan_vien=? ;");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, employee.getSalary());
            preparedStatement.setString(5, employee.getNumberPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());

            System.out.println(employee.getPosition());
            System.out.println(employee.getEducationDegree());
            System.out.println(employee.getDivision());

            preparedStatement.setInt(8, employee.getPosition());
            preparedStatement.setInt(9, employee.getEducationDegree());
            preparedStatement.setInt(10, employee.getDivision());
            preparedStatement.setInt(11, employee.getId());
            rowUpdate= preparedStatement.executeUpdate() >0;
        }
        return rowUpdate;
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        List<Employee> listEmployee=new ArrayList<>();
        try(Connection connection=baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement(" select * from nhan_vien where ho_ten like ?;" );
            preparedStatement.setString(1, '%'+ name + '%');
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name1=rs.getString(2);
                String birthday= rs.getString(3);
                String idCard=rs.getString(4);
                String salary= rs.getString(5);
                String numberPhone=rs.getString(6);
                String email=rs.getString(7);
                String address=rs.getString(8);
                Integer position=rs.getInt(9);
                Integer educationDegree=rs.getInt(10);
                Integer division=rs.getInt(11);
                listEmployee.add(new Employee(id,name1,birthday,idCard,salary,numberPhone,email,address,position,educationDegree,division));
            }
        }
        return listEmployee;
    }

    @Override
    public Employee selectEmployeeById(int id) throws SQLException {
        Employee employee=null;
        try(Connection connection=baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from nhan_vien where ma_nhan_vien=? ");
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while ( rs.next()){
                String name=rs.getString(2);
                String birthday= rs.getString(3);
                String idCard=rs.getString(4);
                String salary=rs.getString(5);
                String numberPhone=rs.getString(6);
                String email=rs.getString(7);
                String address=rs.getString(8);
                Integer position=rs.getInt(9);
                Integer educationDegree=rs.getInt(10);
                Integer division=rs.getInt(11);
                employee= new Employee(id,name,birthday,idCard,salary,numberPhone,email,address,position,educationDegree,division);
            }
        }
        return employee;
    }

    @Override
    public void insertCustomer(Employee employee) {
        try(  Connection connection = baseRepository.getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri, " +
                    " ma_trinh_do,ma_bo_phan) values (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, employee.getSalary());
            preparedStatement.setString(5, employee.getNumberPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            System.out.println(employee.getPosition());
            System.out.println(employee.getEducationDegree());
            System.out.println(employee.getDivision());
            preparedStatement.setInt(8, employee.getPosition());
            preparedStatement.setInt(9, employee.getEducationDegree());
            preparedStatement.setInt(10, employee.getDivision());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
