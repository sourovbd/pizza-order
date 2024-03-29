package com.sv.io.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pizza_id", nullable = false, unique = true)
    private String pizzaId;

    @Column(name = "pizza_type_id", nullable = false)
    private String pizzaTypeId;

    @Column(name = "pizza_types_id")
    private Long pizzaTypesId;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(targetEntity = PizzaTypes.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza_types_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PizzaTypes pizzaTypes;
}
