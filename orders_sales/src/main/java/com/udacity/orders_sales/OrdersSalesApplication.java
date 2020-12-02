package com.udacity.orders_sales;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class OrdersSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersSalesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	/**
	 * Web Client for the maps (location) API
	 * @param endpoint where to communicate for the maps API
	 * @return created maps endpoint
	 */
	@Bean(name="maps")
	public WebClient webClientMaps(@Value("${maps.endpoint}") String endpoint) {
		return WebClient.create(endpoint);
	}

	/**
	 * Web Client for the pricing API
	 * @param endpoint where to communicate for the pricing API
	 * @return created pricing endpoint
	 */
	@Bean(name="pricing")
	public WebClient webClientPricing(@Value("${pricing.endpoint}") String endpoint) {
		return WebClient.create(endpoint);
	}

	/**
	 * Web Client for the vehicles API
	 * @param endpoint where to communicate for the vehicles API
	 * @return created vehicles endpoint
	 */
	@Bean(name="vehicles")
	public WebClient webClientVehicle(@Value("${vehicles.endpoint}") String endpoint) {
		return WebClient.create(endpoint);
	}


}
