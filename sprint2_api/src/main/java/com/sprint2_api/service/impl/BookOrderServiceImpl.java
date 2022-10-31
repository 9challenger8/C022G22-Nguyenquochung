package com.sprint2_api.service.impl;

import com.sprint2_api.model.BookOrder;
import com.sprint2_api.repository.IBookOrderRepository;
import com.sprint2_api.service.IBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookOrderServiceImpl implements IBookOrderService {

    @Autowired
    private IBookOrderRepository iBookOrderRepository;

    @Override
    public void save(BookOrder bookOrder) {
        iBookOrderRepository.save(bookOrder);
    }
}
