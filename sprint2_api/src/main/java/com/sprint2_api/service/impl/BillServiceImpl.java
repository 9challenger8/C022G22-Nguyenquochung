package com.sprint2_api.service.impl;

import com.sprint2_api.model.Bill;
import com.sprint2_api.repository.IBillRepository;
import com.sprint2_api.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    private IBillRepository iBillRepository;

    @Override
    public void save(Bill bill) {
        iBillRepository.save(bill);
    }
}
