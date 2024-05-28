package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "com.repositories")

public class AppConfig {

	@Autowired
	Environment environment;

	private final String URL = "db_url";

	private final String USER = "db_user";

	private final String DRIVER = "db_driver";

	private final String PASSWORD = "db_password";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setPersistenceUnitName("postgresPersistUnit");

		em.setDataSource(dataSource());

		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		// set the hibernate properties

		em.setJpaProperties(hibernateProperties());

		return em;

	}

	@Bean

	DataSource dataSource() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

		driverManagerDataSource.setUrl(environment.getProperty(URL));

		driverManagerDataSource.setUsername(environment.getProperty(USER));

		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));

		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));

		return driverManagerDataSource;

	}

	@Bean

	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;

	}

	private Properties hibernateProperties() {

		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

		properties.setProperty("hibernate.show_sql", "true");

		properties.setProperty("hibernate.format_sql", "true");

		return properties;

	}

}
