package com.demo.products.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Value;

@Value
public class ProductDTO {

    private long id;

    private String name;

    private BigDecimal currentPrice;

    private OffsetDateTime lastUpdate;

}
