package com.demo.products.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class ProductDTO {

    private long id;

    private String name;

    private BigDecimal currentPrice;

    private OffsetDateTime lastUpdate;

    private String description;

}
