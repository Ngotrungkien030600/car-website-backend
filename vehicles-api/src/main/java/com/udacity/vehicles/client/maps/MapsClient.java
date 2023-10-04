package com.udacity.vehicles.client.maps;

import com.udacity.vehicles.domain.Location;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Implements a class to interface with the Maps Client for location data.
 */
@Component
public class MapsClient {

    private static final Logger log = LoggerFactory.getLogger(MapsClient.class);

    private final WebClient client;
    private final ModelMapper mapper;

    public MapsClient(WebClient maps, ModelMapper mapper) {
        this.client = maps;
        this.mapper = mapper;
    }

    /**
     * Gets an address from the Maps client, given latitude and longitude.
     *
     * @param location An object containing "lat" and "lon" of location
     * @return A Mono of updated location including street, city, state and zip,
     * or an exception message noting the Maps service is down
     */
    public Mono<Location> getAddress(Location location) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/maps")
                        .queryParam("lat", location.getLat())
                        .queryParam("lon", location.getLon())
                        .build()
                )
                .retrieve()
                .bodyToMono(Address.class)
                .onErrorResume(e -> {
                    log.warn("Map service is down");
                    return Mono.just(new Address()); // Return an empty address or handle the error as needed
                })
                .flatMap(address -> {
                    mapper.map(Objects.requireNonNull(address), location);
                    return Mono.just(location);
                });
    }
}