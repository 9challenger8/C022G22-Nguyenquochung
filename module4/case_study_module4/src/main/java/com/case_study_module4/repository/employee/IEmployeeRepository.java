package com.case_study_module4.repository.employee;


import com.case_study_module4.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee",nativeQuery = true)
    List<Employee> findAll();

    @Query(value = "select * from employee where id = :id", nativeQuery = true)
    Employee findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from employee where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Query(value = "select * from employee where name like :name", nativeQuery = true,
            countQuery = "select count(*) from (select * from employee where name like :name) abc")
    Page<Employee> findAllByName(@Param("name") String name, Pageable pageable);

}
