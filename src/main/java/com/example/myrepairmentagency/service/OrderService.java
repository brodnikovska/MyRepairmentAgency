package com.example.myrepairmentagency.service;

import com.example.myrepairmentagency.entity.Order;
import com.example.myrepairmentagency.entity.OrderStatus;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.OrdersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Log4j2
public class OrderService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Optional<Order> findByOrderId(Long id) {
        //TODO check for user availability. password check
        return ordersRepository.findById(id);
    }

    public void saveNewOrder(Order order) {
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            ordersRepository.save(order);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }
    }

    @Transactional
    public void setPrice(Order order, double price) {
        order.setCost(price);
        order.setOrderStatus(OrderStatus.PENDING);
        ordersRepository.save(order);
    }


}
