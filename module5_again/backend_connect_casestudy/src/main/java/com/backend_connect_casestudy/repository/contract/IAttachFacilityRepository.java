package com.backend_connect_casestudy.repository.contract;

import com.backend_connect_casestudy.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select * from attach_facility",nativeQuery = true)
    List<AttachFacility> findAll();
}