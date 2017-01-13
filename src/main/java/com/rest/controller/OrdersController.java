package com.rest.controller;

import java.util.List;

import com.rest.model.Orders;
import com.rest.service.OrdersService;
import com.rest.service.RestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private RestService restService;
    @RequestMapping("/orders")
    public String getOrders() {
        List<Orders> all = ordersService.findAll();
        return all.toString();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody JSONObject jsonObject) {
        List<Orders> all = ordersService.findAll();
        ordersService.postRestCall(all);
        for (Orders orders : all) {
            ordersService.updateOrder(orders.isExecuted(), orders.getResponse());
        }

        return all.toString();
    }

}
