package com.rest.service;

import java.util.List;

import com.rest.model.Orders;
import com.rest.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    private RestService restService;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public void postRestCall(List<Orders> orders) {
        for (Orders order : orders) {
            String response = restService
                .doServiceCall(order.getUrl(), order.getBody(), MediaType.APPLICATION_JSON_VALUE);
            order.setResponse(response);
            order.setExecuted(true);
        }
    }

   /* public void updateOrders(List<Orders> all) {
        for (Orders orders : all) {
            ordersRepository.setExecutedStatus(orders.isExecuted(), orders.getResponse());
        }
    }*/
   public void updateOrder(boolean executed, String response) {
           ordersRepository.setExecutedStatus(executed, response);
   }
}
