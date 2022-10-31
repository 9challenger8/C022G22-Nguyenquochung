package com.sprint2_api.repository;

import com.sprint2_api.dto.IHistoryPaymentDto;
import com.sprint2_api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customer c join app_user a " +
            "on c.user_id = a.id where a.username like concat('%',:name,'%')",nativeQuery = true)
    Customer findCustomerByUsername(@Param("name") String name);

    @Query(value = "select customer.name as nameCustomer, bill.date_create as dateCreate, bill.id as timeCreate from customer " +
            "join bill_detail on customer.id = bill_detail.customer_id " +
            "join bill on bill_detail.bill_id = bill.id where customer.id= :id", nativeQuery = true)
    List<IHistoryPaymentDto> getHistoryPayment(@Param("id") Integer id);


}
