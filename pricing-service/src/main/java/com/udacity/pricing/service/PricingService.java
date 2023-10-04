package com.udacity.pricing.service;

import com.udacity.pricing.domain.price.Price;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class PricingService {

    private final List<Price> prices;

    public PricingService() {
        this.prices = generateRandomPrices();
    }

    public List<Price> getPrices() {
        return prices;
    }

    public Price getPrice(Long vehicleId) throws PriceException {
        return prices.stream()
                .filter(price -> price.getVehicleId().equals(vehicleId))
                .findFirst()
                .orElseThrow(() -> new PriceException("Price not found for vehicleId: " + vehicleId));
    }

    private List<Price> generateRandomPrices() {
        return LongStream.range(1, 20)
                .mapToObj(i -> new Price("USD", randomPrice(), i))
                .collect(Collectors.toList());
    }

    private BigDecimal randomPrice() {
        return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal(5000d)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
