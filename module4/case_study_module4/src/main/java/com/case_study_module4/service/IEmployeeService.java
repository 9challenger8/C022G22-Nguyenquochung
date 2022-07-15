package com.case_study_module4.service;

import com.case_study_module4.model.employee.Employee;
import com.case_study_module4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Employee findById(int id) ;

    void removeById(int id);

    void save(Employee employee);

    Page<Employee> findAllByName(String name, Pageable pageable);

    Page<Employee> findAllPageable(Pageable pageable);

    List<Employee> findAll();
}
