package controller;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/matbang")
public class MatBangServlet extends HttpServlet {
    private IMatBangService iMatBangService = new MatBangServiceImpl();
    private ITrangThaiService iTrangThaiService = new TrangThaiServiceImpl();
    private ILoaiMatBangService iLoaiMatBangService = new LoaiMatBangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreate(request, response);
                    break;
                case "delete":
                    deleteMatBang(request, response);
                    break;
                default:
                    listMatBang(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> listMatBang = iMatBangService.selectAllMatbang();
        request.setAttribute("listMatBang", listMatBang);

        List<TrangThai> listTrangThai = iTrangThaiService.selectAll();
        List<LoaiMatBang> listLoaiMatBang = iLoaiMatBangService.selectAll();
        request.setAttribute("listLoaiMatBang", listLoaiMatBang);
        request.setAttribute("listTrangThai", listTrangThai);

        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        iMatBangService.deleteMatBang(id);
        List<MatBang> listMatBang = iMatBangService.selectAllMatbang();
        request.setAttribute("listMatBang", listMatBang);

        List<TrangThai> listTrangThai = iTrangThaiService.selectAll();
        List<LoaiMatBang> listLoaiMatBang = iLoaiMatBangService.selectAll();
        request.setAttribute("listLoaiMatBang", listLoaiMatBang);
        request.setAttribute("listTrangThai", listTrangThai);

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {

        List<TrangThai> listTrangThai = iTrangThaiService.selectAll();
        List<LoaiMatBang> listLoaiMatBang = iLoaiMatBangService.selectAll();
        request.setAttribute("listLoaiMatBang", listLoaiMatBang);
        request.setAttribute("listTrangThai", listTrangThai);

        try {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    saveCustomer(request, response);
                    break;
                case "search":
//                    searchCustomer(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Integer idTrangThai= Integer.valueOf(request.getParameter("idTrangThai"));
        String dienTich=request.getParameter("dienTich");
        Integer tang= Integer.valueOf(request.getParameter("tang"));
        Integer idLoaiMatBang= Integer.valueOf(request.getParameter("idLoaiMatBang"));
        String gia=request.getParameter("gia");
        String ngayBatDau=request.getParameter("ngayBatDau");
        String ngayKetThuc=request.getParameter("ngayKetThuc");


        MatBang matBang = new MatBang(id,idTrangThai,dienTich,tang,idLoaiMatBang,gia,ngayBatDau,ngayKetThuc);
        iMatBangService.insertCustomer(matBang);
        response.sendRedirect("/matbang");
    }
}
