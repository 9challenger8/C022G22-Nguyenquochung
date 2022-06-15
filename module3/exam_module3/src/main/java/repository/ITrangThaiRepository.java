package repository;

import model.LoaiMatBang;
import model.TrangThai;

import java.util.List;

public interface ITrangThaiRepository {
    List<TrangThai> selectAll();
}
