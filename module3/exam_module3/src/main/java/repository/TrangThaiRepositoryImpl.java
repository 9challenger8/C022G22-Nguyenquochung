package repository;

import model.LoaiMatBang;
import model.TrangThai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiRepositoryImpl implements ITrangThaiRepository{
    BaseRepository baseRepository=new BaseRepository();
    @Override
    public List<TrangThai> selectAll() {
        List<TrangThai> list= new ArrayList<>();
        Connection connection=baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from trang_thai");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id= resultSet.getInt(1);
                String name=resultSet.getString(2);
                TrangThai trangThai =new TrangThai(id,name);
                list.add(trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
