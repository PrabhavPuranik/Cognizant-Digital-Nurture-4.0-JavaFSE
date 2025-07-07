package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testFindByNameContaining();
		testFindByNameContainingSorted();
		testFindByNameStartingWith();
		try {
			Thread.sleep(60000); // Keep app running for Postman
		} catch (InterruptedException e) {
			LOGGER.error("Main thread interrupted: {}", e.getMessage());
		}
	}

	private static void testFindByNameContaining() {
		LOGGER.info("Start testFindByNameContaining");
		List<Country> countries = countryService.findByNameContaining("ou");
		LOGGER.debug("Countries with 'ou': {}", countries);
		LOGGER.info("End testFindByNameContaining");
	}

	private static void testFindByNameContainingSorted() {
		LOGGER.info("Start testFindByNameContainingSorted");
		List<Country> countries = countryService.findByNameContainingOrderByNameAsc("ou");
		LOGGER.debug("Sorted Countries with 'ou': {}", countries);
		LOGGER.info("End testFindByNameContainingSorted");
	}

	private static void testFindByNameStartingWith() {
		LOGGER.info("Start testFindByNameStartingWith");
		List<Country> countries = countryService.findByNameStartingWith("Z");
		LOGGER.debug("Countries starting with 'Z': {}", countries);
		LOGGER.info("End testFindByNameStartingWith");
	}

	private static void getAllCountriesTest() {
		LOGGER.info("Start");
		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
			if ("India".equals(country.getName())) {
				LOGGER.info("Country name is valid");
			} else {
				LOGGER.error("Country name is invalid");
			}
		} catch (CountryNotFoundException e) {
			LOGGER.error("Error: {}", e.getMessage());
		}
		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start testAddCountry");
		Country country = new Country();
		country.setCode("XX");
		country.setName("Test Country");
		try {
			countryService.addCountry(country);
			LOGGER.info("Country added successfully");
			Country addedCountry = countryService.findCountryByCode("XX");
			LOGGER.debug("Added Country={}", addedCountry);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Find Error: {}", e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Add Error: {}", e.getMessage());
		}
		LOGGER.info("End testAddCountry");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start testUpdateCountry");
		Country country = new Country();
		country.setCode("XX");
		country.setName("Updated Test Country");
		countryService.updateCountry(country);
		try {
			Country updatedCountry = countryService.findCountryByCode("XX");
			LOGGER.debug("Updated Country={}", updatedCountry);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Error: {}", e.getMessage());
		}
		LOGGER.info("End testUpdateCountry");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start testDeleteCountry");
		countryService.deleteCountry("XX");
		try {
			countryService.findCountryByCode("XX");
			LOGGER.error("Country still exists");
		} catch (CountryNotFoundException e) {
			LOGGER.debug("Deleted Country does not exist, as expected");
		}
		LOGGER.info("End testDeleteCountry");
	}
}