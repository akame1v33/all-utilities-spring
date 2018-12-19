package com.myallutilities.utilities.config.multipledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages                    = "com.pmti.tradestats",
        entityManagerFactoryRef         = "SQLServerLocalContainerEntityManagerFactoryBean",
        transactionManagerRef           = "SQLServerPlatformTransactionManager"
)
public class SQLServerDataSourceConfigPrimary {

    private final String PREFIX = "sqlserver.";

    @Autowired
    private Environment env;


    @Primary
    @Bean(name="SQLServerLocalContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean userEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan(
                new String[] { "com.pmti.tradestats.model" });
//        em.setsc
//        em.setPersistenceProviderClass(PersistenceProvider.class); //If your using eclipse or ch
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));

//        em.setJpaPropertyMap(properties);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Primary
    @Bean(name ="SQLServerPlatformTransactionManager")
    public PlatformTransactionManager userTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                userEntityManager().getObject());
        return transactionManager;
    }

    @Primary
    @Bean(name="SQLServerDataSource")
    public DataSource userDataSource() {
        String driverClassName = env.getProperty(PREFIX+"datasource.driverClassName");
        String url = env.getProperty(PREFIX+"datasource.url");
        String username = env.getProperty(PREFIX+"datasource.username");
        String password = env.getProperty(PREFIX+"datasource.password");
//        System.out.println("DRIVER CLASS NAME -> " +driverClassName);
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);



//        dataSource.get


        return dataSource;
    }







    @Bean(name="SQLServerEntityManager")
    public EntityManagerFactory em(){
        return userEntityManager().getObject();
    }

    //NON BEANS
    public Properties hibernateProperties(){
        final Properties properties = new Properties();

        properties.put("hibernate.connection.driver_class", env.getProperty(PREFIX+"datasource.driverClassName"));
//        properties.put("hibernate.dialect", "c");
        return properties;
    }
}
