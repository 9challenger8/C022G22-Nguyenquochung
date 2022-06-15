package service;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangService {
    void insertCustomer(MatBang matBang);
    List<MatBang> selectAllMatbang();
    boolean deleteMatBang(String id) throws SQLException;
    //    List<MatBang> search(String name,String idCustomerType) throws SQLException;
    MatBang selectById(String id) throws SQLException;
}
