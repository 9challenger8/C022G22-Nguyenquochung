package com.sprint2_api.repository;

import com.sprint2_api.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
}
