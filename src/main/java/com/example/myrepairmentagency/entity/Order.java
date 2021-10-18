package com.example.myrepairmentagency.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "order",
        uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RepairType type;
}
