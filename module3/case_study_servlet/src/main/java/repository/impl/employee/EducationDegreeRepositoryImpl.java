package repository.impl.employee;

import model.employee.EducationDegree;
import repository.iemployee.IEducationDegreeRepository;
import repository.impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    BaseRepository baseRepository =new BaseRepository();
    @Override
    public List<EducationDegree> selectAll() {
        List<EducationDegree> listEducationDegree = new ArrayList<>();
        try(Connection connection= baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement("select * from trinh_do ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name =rs.getString(2);
                listEducationDegree.add(new EducationDegree(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listEducationDegree;
    }
}
