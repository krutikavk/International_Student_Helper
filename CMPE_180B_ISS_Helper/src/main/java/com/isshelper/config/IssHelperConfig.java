package com.isshelper.config;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import com.isshelper.exception.IssHelperException;
import com.isshelper.utils.ApplicationsConstants;

public class IssHelperConfig {

	// PROPERTY BASED CONFIGURATION
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() throws IssHelperException {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		try {
			Properties ymlProperties = getYmlProperties();

			propertySourcesPlaceholderConfigurer.setProperties(ymlProperties);

		} catch (Exception e) {
			throw new IssHelperException("Unable to get YAML properties");
		}
		return propertySourcesPlaceholderConfigurer;

	}

	private static Properties getYmlProperties() throws IOException {
		String activeProfile = System.getenv(ApplicationsConstants.ACTIVE_PROFILE);
		String ymlFile = new ClassPathResource("application-" + activeProfile + ".yml").getFile().toString();
		File ymlInputFile = new File(ymlFile);
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new UrlResource(ymlInputFile.toURI()));

		return yaml.getObject();
	}

// SWAGGER CONFIGURATIONS
	/*
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.empmgmtservice.controller")).
	 * paths(PathSelectors.any()) .build().apiInfo(apiInfo()); }
	 * 
	 * @SuppressWarnings("deprecation") private ApiInfo apiInfo() { return new
	 * ApiInfo("EmployeeMgmtService", "1.0.0", "", "", "Kartik Umalkar",
	 * "OpenSource", "");
	 * 
	 * }
	 */

}
