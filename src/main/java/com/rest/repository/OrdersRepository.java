package com.rest.repository;

import java.util.List;

import com.rest.model.Orders;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface OrdersRepository extends Repository<Orders, Integer> {

    List<Orders> findAll();

    @Modifying
    @Query("update Orders o set o.executed = ?1 where o.response = ?2")
    int setExecutedStatus(boolean executed, String response);

}
