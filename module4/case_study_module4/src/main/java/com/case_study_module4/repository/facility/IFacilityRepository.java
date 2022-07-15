package com.case_study_module4.repository.facility;


import com.case_study_module4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select * from facility where id = :id", nativeQuery = true)
    Facility findById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from facility where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Query(value = "select * from facility where name like :name", nativeQuery = true,
            countQuery = "select count(*) from (select * from facility where name like :name) abc")
    Page<Facility> findAllByName(@Param("name") String name, Pageable pageable);
}
