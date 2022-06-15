package service;

import model.LoaiMatBang;
import repository.ILoaiMatBangRepository;
import repository.LoaiMatBangRepository;

import java.util.List;

public class LoaiMatBangServiceImpl implements ILoaiMatBangService{
    private ILoaiMatBangRepository iLoaiMatBangRepository = new LoaiMatBangRepository();
    @Override
    public List<LoaiMatBang> selectAll() {
        return iLoaiMatBangRepository.selectAll() ;
    }
}
