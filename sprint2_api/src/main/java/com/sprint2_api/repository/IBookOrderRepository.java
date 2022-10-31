package com.sprint2_api.repository;

import com.sprint2_api.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookOrderRepository extends JpaRepository<BookOrder,Integer> {


}
