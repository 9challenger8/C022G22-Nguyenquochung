package common;

import model.customer.CustomerType;
import service.icustomer.ICustomerTypeService;
import service.iemployee.IDivisionService;
import service.iemployee.IEducationDegreeService;
import service.iemployee.IPositionService;
import service.impl.customer.CustomerTypeServiceImpl;
import service.impl.employee.DivisionServiceImpl;
import service.impl.employee.EducationDegreeServiceImpl;
import service.impl.employee.PositionServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validate {
    private static ICustomerTypeService iCustomerTypeService = new CustomerTypeServiceImpl();
    private static IPositionService iPositionService = new PositionServiceImpl();
    private static IEducationDegreeService iEducationDegreeService = new EducationDegreeServiceImpl();
    private static IDivisionService iDivisionService = new DivisionServiceImpl();
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String ID_CARD = "^[0-9]{9}|[0-9]{12}$";
    public static final String NUMBER_PHONE = "^090[0-9]{7}|091[0-9]{7}|(84)\\+90[0-9]{7}|(84)\\+91[0-9]{7}$";
    public static final String SALARY = "^[0-9]*[0-9][\\\\.]?[0-9]*$";

    public static Map<String, String> regexEmail(String email) {
        Map<String, String> errors = new HashMap<>();
        if (email.equals("")) {
            errors.put("email", "Email is not null.");
        } else if (!email.matches(EMAIL_REGEX)) {
            errors.put("email", "Email is invalid.");
        }
        return errors;
    }

    public static Map<String, String> regexName(String name) {
        Map<String, String> errors = new HashMap<>();
        if (name.equals("")) {
            errors.put("name", "Name is not null.");
        }
        return errors;
    }

    public static Map<String, String> regexAddress(String address) {
        Map<String, String> errors = new HashMap<>();
        if (address.equals("")) {
            errors.put("address", "Address is not null.");
        }
        return errors;
    }

    public static Map<String, String> regexPosition(String position) {
        Map<String, String> errors = new HashMap<>();
        if (position.equals("")) {
            errors.put("position", "Position is not null.");
        }
        return errors;
    }

    public static Map<String, String> regexEducationDegree(String edu) {
        Map<String, String> errors = new HashMap<>();
        if (edu.equals("")) {
            errors.put("educationDegree", "Education Degree is not null.");
        }
        return errors;
    }

    public static Map<String, String> regexDivision(String division) {
        Map<String, String> errors = new HashMap<>();
        if (division.equals("")) {
            errors.put("division", "Division is not null.");
        }
        return errors;
    }

    public static Map<String, String> regexIdCard(String idCard) {
        Map<String, String> errors = new HashMap<>();
        if (idCard.equals("")) {
            errors.put("idCard", "ID Card is not null.");
        } else if (!idCard.matches(ID_CARD)) {
            errors.put("idCard", "ID Card is invalid.");
        }
        return errors;
    }

    public static Map<String, String> regexNumberPhone(String numberPhone) {
        Map<String, String> errors = new HashMap<>();

        if (numberPhone.equals("")) {
            errors.put("numberPhone", "Number Phone is not null");
        }
        else if (!numberPhone.matches(NUMBER_PHONE)) {
            errors.put("numberPhone", "Number Phone is invalid.");
        }

        return errors;
    }

    public static Map<String, String> regexSalary(String salary) {
        Map<String, String> errors = new HashMap<>();
        if (salary.equals("")) {
            errors.put("salary", "Salary is not null.");
        } else if (!salary.matches(SALARY)) {
            errors.put("salary", "Salary is invalid.");
        }
        return errors;
    }

}
