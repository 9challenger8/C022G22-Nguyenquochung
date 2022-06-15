package repository;

import model.LoaiMatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiMatBangRepository implements ILoaiMatBangRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<LoaiMatBang> selectAll() {
        List<LoaiMatBang> list = new ArrayList<>();
        Connection connection = baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from loai_mat_bang");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                LoaiMatBang loaiMatBang = new LoaiMatBang(id, name);
                list.add(loaiMatBang);
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

