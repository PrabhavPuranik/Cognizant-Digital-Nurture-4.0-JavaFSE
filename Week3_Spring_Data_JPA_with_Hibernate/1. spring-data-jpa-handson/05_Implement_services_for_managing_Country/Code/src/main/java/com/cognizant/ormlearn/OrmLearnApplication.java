package com.cognizant.ormlearn;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testFindByCode();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		testFindByNameContaining();
	}

	private static void testFindByCode() {
		LOGGER.info("Start testFindByCode");
		Optional<Country> country = countryService.findByCode("IN");
		LOGGER.debug("Country={}", country.orElse(null));
		LOGGER.info("End testFindByCode");
	}

	private static void testAddCountry() {
		LOGGER.info("Start testAddCountry");
		Country country = new Country();
		country.setCode("XX");
		country.setName("Test Country");
		countryService.addCountry(country);
		Optional<Country> addedCountry = countryService.findByCode("XX");
		LOGGER.debug("Added Country={}", addedCountry.orElse(null));
		LOGGER.info("End testAddCountry");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start testUpdateCountry");
		Country country = new Country();
		country.setCode("XX");
		country.setName("Updated Test Country");
		countryService.updateCountry(country);
		Optional<Country> updatedCountry = countryService.findByCode("XX");
		LOGGER.debug("Updated Country={}", updatedCountry.orElse(null));
		LOGGER.info("End testUpdateCountry");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start testDeleteCountry");
		countryService.deleteCountry("XX");
		Optional<Country> deletedCountry = countryService.findByCode("XX");
		LOGGER.debug("Deleted Country Exists={}", deletedCountry.isPresent());
		LOGGER.info("End testDeleteCountry");
	}

	private static void testFindByNameContaining() {
		LOGGER.info("Start testFindByNameContaining");
		List<Country> countries = countryService.findByNameContaining("land");
		LOGGER.debug("Countries={}", countries);
		LOGGER.info("End testFindByNameContaining");
	}
}