package controller;

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
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
    public class EmployeeServlet extends HttpServlet {
        private IDivisionService iDivisionService=new DivisionServiceImpl();
        private IPositionService iPositionService = new PositionServiceImpl();
        private IEducationDegreeService iEducationDegreeService=new EducationDegreeServiceImpl();
        private IEmployeeService iEmployeeService=new EmployeeServiceImpl();
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
            List<Position> listPosition= iPositionService.selectAll();
            request.setAttribute("listPosition",listPosition);
            List<EducationDegree> listEducationDegree= iEducationDegreeService.selectAll();
            request.setAttribute("listEducationDegree",listEducationDegree);
            List<Division> listDivision= iDivisionService.selectAll();
            request.setAttribute("listDivision",listDivision);
            request.getRequestDispatcher("employee/edit_employee.jsp").forward(request,response);
        }

        private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Employee>  listEmployee= iEmployeeService.selectAllEmployee();
            request.setAttribute("listEmployee",listEmployee);
            request.getRequestDispatcher("employee/list_employee.jsp").forward(request,response);
        }

        private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            iEmployeeService.deleteEmployee(id);
            List<Employee>  listEmployee= iEmployeeService.selectAllEmployee();
            request.setAttribute("listEmployee",listEmployee);
            request.getRequestDispatcher("employee/list_employee.jsp").forward(request,response);
        }

        private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Position> listPosition= iPositionService.selectAll();
            request.setAttribute("listPosition",listPosition);
            List<EducationDegree> listEducationDegree= iEducationDegreeService.selectAll();
            request.setAttribute("listEducationDegree",listEducationDegree);
            List<Division> listDivision= iDivisionService.selectAll();
            request.setAttribute("listDivision",listDivision);

            request.getRequestDispatcher("/employee/create_employee.jsp").forward(request,response);

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
                        saveEmployee(request,response);
                        break;
                    case "edit":
                        updateEmployee(request,response);
                        break;
                    case "search":
                        searchEmployee(request,response);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name=request.getParameter("search");
        List<Employee>  listEmployee = iEmployeeService.searchByName(name);
        request.setAttribute("listEmployee",listEmployee);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request,response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        String idCard=request.getParameter("numberCMND");
        String salary=request.getParameter("salary");
        String numberPhone=request.getParameter("numberPhone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Integer position = Integer.valueOf(request.getParameter("position"));
        Integer educationDegree = Integer.valueOf(request.getParameter("educationDegree"));
        Integer division = Integer.valueOf(request.getParameter("division"));
        Employee employee=new Employee(id,name,birthday,idCard,salary,numberPhone,email,address,position,educationDegree,division);
        iEmployeeService.updateEmployee(employee);

        List<Employee>  listEmployee= iEmployeeService.selectAllEmployee();
        request.setAttribute("listEmployee",listEmployee);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request,response);
    }

    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String birthday=request.getParameter("birthday");
        String idCard=request.getParameter("numberCMND");
        String salary=request.getParameter("salary");
        String numberPhone=request.getParameter("numberPhone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Integer position = Integer.valueOf(request.getParameter("position"));
        Integer educationDegree = Integer.valueOf(request.getParameter("educationDegree"));
        Integer division = Integer.valueOf(request.getParameter("division"));
        Employee employee=new Employee(name,birthday,idCard,salary,numberPhone,email,address,position,educationDegree,division);
        iEmployeeService.insertEmployee(employee);

        List<Employee>  listEmployee= iEmployeeService.selectAllEmployee();
        request.setAttribute("listEmployee",listEmployee);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request,response);

    }
}

