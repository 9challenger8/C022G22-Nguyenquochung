package com.sprint2_api.repository;

import com.sprint2_api.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBillRepository extends JpaRepository<Bill,Integer> {

}
