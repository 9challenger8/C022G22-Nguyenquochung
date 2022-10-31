package com.sprint2_api.repository;

import com.sprint2_api.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<Publisher,Integer> {
}
