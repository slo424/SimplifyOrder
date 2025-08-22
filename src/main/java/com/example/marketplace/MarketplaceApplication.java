package com.example.marketplace;


import com.example.marketplace.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Configurable
@EnableMongoRepositories(basePackageClasses = OrderRepository.class)
//@EnableMongoRepositories(basePackages = "com.example.marketplace.repositories")
public class MarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}
}
