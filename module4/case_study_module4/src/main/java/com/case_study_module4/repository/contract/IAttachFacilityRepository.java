package com.case_study_module4.repository.contract;

import com.case_study_module4.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select * from attach_facility",nativeQuery = true)
    List<AttachFacility> findAll();
}
