package com.exam_module4.repository;

import com.exam_module4.model.Contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "select * from contract where id = :id", nativeQuery = true)
    Contract findById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "delete from contract where id = :id", nativeQuery = true)
    void removeById(@Param("id") String id);

    @Query(value = "select * from contract",nativeQuery = true)
    List<Contract> findAll();
}
