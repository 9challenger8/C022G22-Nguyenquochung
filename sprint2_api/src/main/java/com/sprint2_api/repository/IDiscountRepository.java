package com.sprint2_api.repository;

import com.sprint2_api.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscountRepository extends JpaRepository<Discount,Integer> {
}
