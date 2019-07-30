package com.eventoapp;


import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
	
	@Bean
	public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("postgres://eujalshowhiqek:dd861a9ba6616a5f2ccccbcc1e39fe7d65637b139695d9a924e65e1cfa219325@ec2-54-243-193-59.compute-1.amazonaws.com:5432/d12fri682q48ph"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
	
	/* conectando com mysql
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://remotemysql.com:3306/Ri4t4wr2kY");
		dataSource.setUsername("Ri4t4wr2kY");
		dataSource.setPassword("bEPANlgbQD");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		adapter.setPrepareConnection(true);		
		return adapter;
	}
	
	*/
}
