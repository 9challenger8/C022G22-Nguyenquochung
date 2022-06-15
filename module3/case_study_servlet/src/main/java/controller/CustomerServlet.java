package controller;

import common.Validate;
import model.customer.Customer;
import model.customer.CustomerType;
import service.icustomer.ICustomerService;
import service.icustomer.ICustomerTypeService;
import service.impl.customer.CustomerServiceImpl;
import service.impl.customer.CustomerTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService iCustomerService=new CustomerServiceImpl();
    private final ICustomerTypeService iCustomerTypeService=new CustomerTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
       try {
           switch (action){
               case "create":
                   showFormCreate(request,response);
                   break;
               case "delete":
                   deleteCustomer(request,response);
                   break;
               case "edit":
                   showFormEdit(request,response);
                   break;
               default:
                   listCustomer(request,response);
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        try {
            switch (action){
                case "create":
                    saveCustomer(request,response);
                    break;
                case "edit":
                    updateCustomer(request,response);
                    break;
                case "search":
                    searchCustomer(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.deleteUser(id);
        List<Customer>  listCustomer= iCustomerService.selectAllCustomers();
        request.setAttribute("listCustomer",listCustomer);
        List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
        request.setAttribute("listCustomerType",listCustomerType);
        request.getRequestDispatcher("customer/list_customer.jsp").forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = iCustomerService.selectUserById(id);
        request.setAttribute("customer", existingCustomer);
        List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
        request.setAttribute("listCustomerType",listCustomerType);
        request.getRequestDispatcher("customer/edit_customer.jsp").forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
        request.setAttribute("listCustomerType",listCustomerType);

        try {
            request.getRequestDispatcher("/customer/create_customer.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer= iCustomerService.selectAllCustomers();
        List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
        request.setAttribute("listCustomerType",listCustomerType);
        request.setAttribute("listCustomer",listCustomer);
        request.getRequestDispatcher("customer/list_customer.jsp").forward(request,response);
    }



    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
        String name=request.getParameter("search");
        String id = request.getParameter("customerTypeId");
        List<Customer>  listCustomer = iCustomerService.searchByName(name,id);
        request.setAttribute("listCustomerType",listCustomerType);
        request.setAttribute("listCustomer",listCustomer);
        request.setAttribute("search",name);
        request.setAttribute("customer",id);
        request.getRequestDispatcher("customer/list_customer.jsp").forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Map<String,String> errors=new HashMap<>();
        Map<String,String> errors1 ;
        Map<String,String> errors2 ;
        Map<String,String> errors3 ;
        Map<String,String> errors4 ;
        Map<String,String> errors5 ;

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        Integer gender= Integer.valueOf(request.getParameter("gender"));
        String idCard=request.getParameter("numberCMND");
        String numberPhone=request.getParameter("numberPhone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Integer typeId = Integer.valueOf(request.getParameter("customerTypeId"));

        errors1= Validate.regexEmail(email);
        errors2= Validate.regexIdCard(idCard);
        errors3=Validate.regexNumberPhone(numberPhone);
        errors4=Validate.regexName(name);
        errors5=Validate.regexAddress(address);
        errors.putAll(errors1);
        errors.putAll(errors2);
        errors.putAll(errors3);
        errors.putAll(errors4);
        errors.putAll(errors5);

        if (errors.isEmpty()){
            Customer customer=new Customer(id,name,birthday,gender,idCard,numberPhone,email,address,typeId);
            iCustomerService.updateUser(customer);
            response.sendRedirect("/customers");
        }else {

            List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
            request.setAttribute("listCustomerType",listCustomerType);
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("customer/create_customer.jsp").forward(request,response);
        }

    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> errors=new HashMap<>();
        Map<String,String> errors1 ;
        Map<String,String> errors2 ;
        Map<String,String> errors3 ;
        Map<String,String> errors4 ;
        Map<String,String> errors5 ;


        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        System.out.println(request.getParameter("birthday"));
        Integer gender= Integer.valueOf(request.getParameter("gender"));
        String idCard=request.getParameter("numberCMND");
        String numberPhone=request.getParameter("numberPhone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Integer typeId = Integer.valueOf(request.getParameter("customerTypeId"));

        errors1= Validate.regexEmail(email);
        errors2= Validate.regexIdCard(idCard);
        errors3=Validate.regexNumberPhone(numberPhone);
        errors4=Validate.regexName(name);
        errors5=Validate.regexAddress(address);

        errors.putAll(errors1);
        errors.putAll(errors2);
        errors.putAll(errors3);
        errors.putAll(errors4);
        errors.putAll(errors5);

        if (errors.isEmpty()){
            Customer customer=new Customer(name,birthday,gender,idCard,numberPhone,email,address,typeId);
            iCustomerService.insertCustomer(customer);
            response.sendRedirect("/customers");
        }else {

            List<CustomerType> listCustomerType= iCustomerTypeService.selectAllCustomerType();
            request.setAttribute("listCustomerType",listCustomerType);
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("customer/create_customer.jsp").forward(request,response);
        }


    }
}
