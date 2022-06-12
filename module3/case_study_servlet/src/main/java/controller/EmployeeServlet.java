package controller;

import common.Validate;
import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import service.iemployee.IDivisionService;
import service.iemployee.IEducationDegreeService;
import service.iemployee.IEmployeeService;
import service.iemployee.IPositionService;

import service.impl.employee.DivisionServiceImpl;
import service.impl.employee.EducationDegreeServiceImpl;
import service.impl.employee.EmployeeServiceImpl;
import service.impl.employee.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private IDivisionService iDivisionService = new DivisionServiceImpl();
    private IPositionService iPositionService = new PositionServiceImpl();
    private IEducationDegreeService iEducationDegreeService = new EducationDegreeServiceImpl();
    private IEmployeeService iEmployeeService = new EmployeeServiceImpl();

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
                    deleteEmployee(request, response);
                    break;
                case "edit":
                    showFormEdit(request, response);
                    break;
                default:
                    listEmployee(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = iEmployeeService.selectEmployeeById(id);
        request.setAttribute("employee", existingEmployee);
        List<Position> listPosition = iPositionService.selectAll();
        request.setAttribute("listPosition", listPosition);
        List<EducationDegree> listEducationDegree = iEducationDegreeService.selectAll();
        request.setAttribute("listEducationDegree", listEducationDegree);
        List<Division> listDivision = iDivisionService.selectAll();
        request.setAttribute("listDivision", listDivision);
        request.getRequestDispatcher("employee/edit_employee.jsp").forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listEmployee = iEmployeeService.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        iEmployeeService.deleteEmployee(id);
        List<Employee> listEmployee = iEmployeeService.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> listPosition = iPositionService.selectAll();
        request.setAttribute("listPosition", listPosition);

        List<EducationDegree> listEducationDegree = iEducationDegreeService.selectAll();
        request.setAttribute("listEducationDegree", listEducationDegree);

        List<Division> listDivision = iDivisionService.selectAll();
        request.setAttribute("listDivision", listDivision);

        request.getRequestDispatcher("/employee/create_employee.jsp").forward(request, response);

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
                    saveEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("search");
        List<Employee> listEmployee = iEmployeeService.searchByName(name);
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        Map<String,String> errors=new HashMap<>();
        Map<String,String> errors1 ;
        Map<String,String> errors2 ;
        Map<String,String> errors3 ;
        Map<String,String> errors4 ;
        Map<String,String> errors5 ;
        Map<String,String> errors6 ;
        Map<String,String> errors7 ;
        Map<String,String> errors8 ;
        Map<String,String> errors9 ;

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("numberCMND");
        String salary = request.getParameter("salary");
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        String position = request.getParameter("position");

        String educationDegree = request.getParameter("educationDegree");

        String division = request.getParameter("division");

        errors1= Validate.regexEmail(email);
        errors2= Validate.regexIdCard(idCard);
        errors3=Validate.regexNumberPhone(numberPhone);
        errors4=Validate.regexName(name);
        errors5=Validate.regexAddress(address);
        errors6=Validate.regexSalary(salary);
        errors7=Validate.regexPosition(position);
        errors8=Validate.regexEducationDegree(salary);
        errors9=Validate.regexDivision(division);

        errors.putAll(errors1);
        errors.putAll(errors2);
        errors.putAll(errors3);
        errors.putAll(errors4);
        errors.putAll(errors5);
        errors.putAll(errors6);
        errors.putAll(errors7);
        errors.putAll(errors8);
        errors.putAll(errors9);
        Employee employee1 = new Employee(id, name, birthday, idCard, salary, numberPhone, email, address, Integer.parseInt( position),
                Integer.parseInt( educationDegree),Integer.parseInt(division));
        if(errors.isEmpty()){

            iEmployeeService.updateEmployee(employee1);
            response.sendRedirect("/employees");
        }else {
            List<Position> listPosition = iPositionService.selectAll();
            request.setAttribute("listPosition", listPosition);

            List<EducationDegree> listEducationDegree = iEducationDegreeService.selectAll();
            request.setAttribute("listEducationDegree", listEducationDegree);

            List<Division> listDivision = iDivisionService.selectAll();
            request.setAttribute("listDivision", listDivision);
            request.setAttribute("errors",errors);

            request.setAttribute("employee",employee1);

            request.getRequestDispatcher("/employee/edit_employee.jsp").forward(request, response);

        }
    }

    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> errors=new HashMap<>();
        Map<String,String> errors1 ;
        Map<String,String> errors2 ;
        Map<String,String> errors3 ;
        Map<String,String> errors4 ;
        Map<String,String> errors5 ;
        Map<String,String> errors6 ;
        Map<String,String> errors7 ;
        Map<String,String> errors8 ;
        Map<String,String> errors9 ;

        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("numberCMND");
        String salary = request.getParameter("salary");
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        String position = request.getParameter("position");

        String educationDegree = request.getParameter("educationDegree");

        String division = request.getParameter("division");

        errors1= Validate.regexEmail(email);
        errors2= Validate.regexIdCard(idCard);
        errors3=Validate.regexNumberPhone(numberPhone);
        errors4=Validate.regexName(name);
        errors5=Validate.regexAddress(address);
        errors6=Validate.regexSalary(salary);
        errors7=Validate.regexPosition(position);
        errors8=Validate.regexEducationDegree(salary);
        errors9=Validate.regexDivision(division);

        errors.putAll(errors1);
        errors.putAll(errors2);
        errors.putAll(errors3);
        errors.putAll(errors4);
        errors.putAll(errors5);
        errors.putAll(errors6);
        errors.putAll(errors7);
        errors.putAll(errors8);
        errors.putAll(errors9);
        if(errors.isEmpty()){
            Employee employee = new Employee( name, birthday, idCard, salary, numberPhone, email, address, Integer.parseInt( position),
                    Integer.parseInt( educationDegree),Integer.parseInt(division));
            iEmployeeService.insertEmployee(employee);
            response.sendRedirect("/employees");
        }else {
            List<Position> listPosition = iPositionService.selectAll();
            request.setAttribute("listPosition", listPosition);

            List<EducationDegree> listEducationDegree = iEducationDegreeService.selectAll();
            request.setAttribute("listEducationDegree", listEducationDegree);

            List<Division> listDivision = iDivisionService.selectAll();
            request.setAttribute("listDivision", listDivision);
            request.setAttribute("errors",errors);

            request.getRequestDispatcher("/employee/create_employee.jsp").forward(request, response);

        }
    }
}

