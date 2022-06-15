package repository;

import model.LoaiMatBang;

import java.util.List;

public interface ILoaiMatBangRepository {
    List<LoaiMatBang> selectAll();
}
