package com.udacity.pricing.domain.price;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    private String currency;
    private BigDecimal price;
    private Long vehicleId;

    public Price() {
    }

    public Price(String currency, BigDecimal price, Long vehicleId) {
        this.currency = currency;
        this.price = price;
        this.vehicleId = vehicleId;
    }
}
