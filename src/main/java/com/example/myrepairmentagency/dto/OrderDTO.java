package com.example.myrepairmentagency.dto;

import com.example.myrepairmentagency.entity.OrderStatus;
import com.example.myrepairmentagency.entity.RepairType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDTO {
    Long id;
    Long user_id;
    double cost;
    RepairType type;
    OrderStatus orderStatus;
}
