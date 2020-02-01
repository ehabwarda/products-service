package com.demo.products.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENT_PRICE")
    private BigDecimal currentPrice;

    @Column(name = "LAST_UPDATE")
    @LastModifiedDate
    private OffsetDateTime lastUpdate;

    @PreUpdate
    void onPersist() {
        setLastUpdate(OffsetDateTime.now());
    }
}
