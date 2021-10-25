package com.example.myrepairmentagency.repository;

import com.example.myrepairmentagency.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
}