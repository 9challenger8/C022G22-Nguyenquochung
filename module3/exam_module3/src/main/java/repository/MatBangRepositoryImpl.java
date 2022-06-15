package repository;

import model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepositoryImpl implements IMatBangRepository {
    private final BaseRepository baseRepository = new BaseRepository();

    @Override
    public void insertCustomer(MatBang matBang) {
        Connection connection = baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into mat_bang_cho_thue (ma_mat_bang,ma_trang_thai,dien_tich,tang,ma_loai_mat_bang,gia_tien,ngay_bat_dau,ngay_ket_thuc) " +
                    " values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, matBang.getId());
            preparedStatement.setInt(2, matBang.getIdTrangThai());
            preparedStatement.setString(3, matBang.getDienTich());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setInt(5, matBang.getIdLoaiMatBang());
            preparedStatement.setString(6, matBang.getGia());
            preparedStatement.setString(7, matBang.getNgayBatDau());
            preparedStatement.setString(8, matBang.getNgayKetThuc());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MatBang> selectAllMatbang() {
        List<MatBang> listMatBang = new ArrayList<>();
        Connection connection = baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from mat_bang_cho_thue");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                Integer idTrangThai = rs.getInt(2);
                String dienTich=rs.getString(3);
                Integer tang=rs.getInt(4);
                Integer idLoaiMatBang=rs.getInt(5);
                String gia=rs.getString(6);
                String ngayBatDau=rs.getString(7);
                String ngayKetThuc=rs.getString(8);

                listMatBang.add(new MatBang(id,idTrangThai,dienTich,tang,idLoaiMatBang,gia,ngayBatDau,ngayKetThuc));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMatBang;
    }

    @Override
    public boolean deleteMatBang(String id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement=connection.prepareStatement("delete from mat_bang_cho_thue where ma_mat_bang = ?;");
            preparedStatement.setString(1,id);
            rowDelete= preparedStatement.executeUpdate()>0;
        }
        return rowDelete;
    }

    @Override
    public MatBang selectById(String id) throws SQLException {
        MatBang matBang=null;
        try(Connection connection=baseRepository.getConnectionJavaToDB()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from mat_bang_cho_thue where ma_mat_bang=? ");
            preparedStatement.setString(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while ( rs.next()){
                Integer idTrangThai = rs.getInt(2);
                String dienTich=rs.getString(3);
                Integer tang=rs.getInt(4);
                Integer idLoaiMatBang=rs.getInt(5);
                String gia=rs.getString(6);
                String ngayBatDau=rs.getString(7);
                String ngayKetThuc=rs.getString(8);
                matBang=new MatBang(id,idTrangThai,dienTich,tang,idLoaiMatBang,gia,ngayBatDau,ngayKetThuc);
            }
        }
        return matBang;
    }
}
