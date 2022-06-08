package repository.impl.employee;

import model.employee.EducationDegree;
import model.employee.Position;
import repository.iemployee.IPositionRepository;
import repository.impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    BaseRepository baseRepository =new BaseRepository();
    @Override
    public List<Position> selectAll() {
        List<Position> listPosition = new ArrayList<>();
        try(Connection connection= baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement("select * from vi_tri ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name =rs.getString(2);
                listPosition.add(new Position(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listPosition;
    }
}
