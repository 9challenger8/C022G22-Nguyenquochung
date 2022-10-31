package com.sprint2_api.service.impl;

import com.sprint2_api.model.BillDetail;
import com.sprint2_api.repository.IBillDetailRepository;
import com.sprint2_api.service.IBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailServiceImpl implements IBillDetailService {
    @Autowired
    private IBillDetailRepository iBillDetailRepository;

    @Override
    public void save(BillDetail billDetail) {
        iBillDetailRepository.save(billDetail);
    }
}
