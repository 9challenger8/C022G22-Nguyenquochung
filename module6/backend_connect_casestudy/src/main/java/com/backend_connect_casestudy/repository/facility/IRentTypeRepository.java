package com.backend_connect_casestudy.repository.facility;

import com.backend_connect_casestudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
    @Query(value = "select * from rent_type",nativeQuery = true)
    List<RentType> findAll();
}
