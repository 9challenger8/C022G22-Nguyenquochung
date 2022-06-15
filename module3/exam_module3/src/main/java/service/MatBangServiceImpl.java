package service;

import model.MatBang;
import repository.IMatBangRepository;
import repository.MatBangRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class MatBangServiceImpl implements IMatBangService{
    private IMatBangRepository iMatBangRepository=new MatBangRepositoryImpl();
    @Override
    public void insertCustomer(MatBang matBang) {
        iMatBangRepository.insertCustomer(matBang);
    }

    @Override
    public List<MatBang> selectAllMatbang() {
        return iMatBangRepository.selectAllMatbang();
    }

    @Override
    public boolean deleteMatBang(String id) throws SQLException {
        boolean rowDelete;
        rowDelete=iMatBangRepository.deleteMatBang(id);
        return rowDelete;
    }

    @Override
    public MatBang selectById(String id) throws SQLException {
        return iMatBangRepository.selectById(id);
    }
}
