package sif3.au.naplan.provider.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import sif3.au.naplan.api.client.NaplanClient;

@Configuration
@ComponentScan(basePackages = "sif3.au.naplan.provider")
public class NaplanConfiguration {
	static Logger L = LoggerFactory.getLogger(NaplanConfiguration.class);
	
	@Value("${naplan.api.endpoint}")
	String naplanEndpoint;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholder() {
		L.info("initialising property placeholder");
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		placeholderConfigurer.setIgnoreResourceNotFound(false);
		placeholderConfigurer.setLocation(new ClassPathResource("NaplanProvider.properties"));
		return placeholderConfigurer;
	}
	
	@Bean
	public NaplanClient naplanClient() {
		return NaplanClient.initialise(naplanEndpoint);
	}
	

}