package repository.impl.employee;

import model.employee.Division;
import repository.iemployee.IDivisionRepository;
import repository.impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    BaseRepository baseRepository =new BaseRepository();
    @Override
    public List<Division> selectAll() {
        List<Division> listDivision = new ArrayList<>();
        try(Connection connection= baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement("select * from bo_phan ");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name =rs.getString(2);
                listDivision.add(new Division(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listDivision;
    }
}
