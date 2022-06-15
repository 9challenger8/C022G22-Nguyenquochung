package service;

import model.TrangThai;
import repository.ITrangThaiRepository;
import repository.TrangThaiRepositoryImpl;

import java.util.List;

public class TrangThaiServiceImpl implements ITrangThaiService{
    private ITrangThaiRepository iTrangThaiRepository=new TrangThaiRepositoryImpl();

    @Override
    public List<TrangThai> selectAll() {
        return iTrangThaiRepository.selectAll();
    }
}
