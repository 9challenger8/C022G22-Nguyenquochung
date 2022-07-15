package com.case_study_module4.repository.facility;

import com.case_study_module4.model.customer.CustomerType;
import com.case_study_module4.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
    @Query(value = "select * from facility_type",nativeQuery = true)
    List<FacilityType> findAll();
}
