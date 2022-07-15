package com.case_study_module4.service.employee;

import com.case_study_module4.model.employee.Employee;
import com.case_study_module4.repository.employee.IEmployeeRepository;
import com.case_study_module4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void removeById(int id) {
        iEmployeeRepository.removeById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAllByName(String name, Pageable pageable) {
        return iEmployeeRepository.findAllByName(name,pageable);
    }

    @Override
    public Page<Employee> findAllPageable(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
