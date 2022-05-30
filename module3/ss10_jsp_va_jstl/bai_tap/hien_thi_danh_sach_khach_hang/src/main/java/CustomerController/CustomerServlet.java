package CustomerController;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")

public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer[] customers=new Customer[5];
        customers[0]= new Customer("Jonh wick","10-10-1999","America","https://nld.mediacdn.vn/291774122806476800/2022/3/29/photo-1-1648550112535397905915.jpeg");
        customers[1]= new Customer("RonaNho","10-10-2000","America","https://s1.media.ngoisao.vn/resize_580/news/2021/07/31/le-phuong-anh-ngosaovn-1-ngoisaovn-w1536-h2048.jpg");
        customers[2]= new Customer("Bec ham","10-10-1944","Dubai","https://vieclamthemonline.com/wp-content/uploads/2021/10/hinh-anh-tram-anh.jpg");
        customers[3]= new Customer("Rose","10-10-1989","Brazil","https://thekymoi.vn/wp-content/uploads/2020/01/hot-girl-nguyen-ngoc-anh3-1.jpg");
        customers[4]= new Customer("Alalia","10-1-1599","America","https://thoidai.com.vn/stores/news_dataimages/trang.chu/042019/12/15/5047_9.jpg");

        request.setAttribute("listCustomer",customers);

        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
