package com.udacity.pricing.api;

import com.udacity.pricing.domain.price.Price;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements a REST-based controller for the pricing service.
 */
@RestController
@RequestMapping("/services/price")
public class PricingController {

    /**
     * Gets the price for a requested vehicle.
     * @param vehicleId ID number of the vehicle for which the price is requested
     * @return price of the vehicle, or error that it was not found.
     */
    @GetMapping
    public Price get(@RequestParam Long vehicleId) {
        /**
         * TODO: Use the PricingService to handle a GET request for price
         *   based on a vehicleID input. Make sure it can handle exceptions,
         *   either here or in the PricingService.
         *   The below code should be removed.
         */
        Price price = new Price("USD", BigDecimal.ZERO, 0L);
        return price;

    }
}
