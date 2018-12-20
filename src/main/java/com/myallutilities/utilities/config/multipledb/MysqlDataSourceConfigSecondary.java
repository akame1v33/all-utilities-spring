//package com.myallutilities.utilities.config.multipledb;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages                = "com.pmti.tradestats",
//        entityManagerFactoryRef     = "MYSQLLocalContainerEntityManagerFactoryBean",
//        transactionManagerRef       = "MYSQLPlatformTransactionManager"
//)
//public class MysqlDataSourceConfigSecondary {
////
////
//
//    private final String PREFIX = "mysql.";
//
//    @Autowired
//    private Environment env;
//
//
//    @Bean(name="MYSQLLocalContainerEntityManagerFactoryBean")
//    public LocalContainerEntityManagerFactoryBean userEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(userDataSource());
//        em.setPackagesToScan(
//                new String[] { "com.pmti.tradestats.mysql.models" });
//
//        HibernateJpaVendorAdapter vendorAdapter
//                = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
////        HashMap<String, Object> properties = new HashMap<>();
////        properties.put("hibernate.hbm2ddl.auto",
////                env.getProperty("hibernate.hbm2ddl.auto"));
////        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
////        em.setJpaPropertyMap(properties);
//
//        em.setJpaProperties(hibernateProperties());
//
//        return em;
//    }
//
//    @Bean(name ="MYSQLPlatformTransactionManager")
//    public PlatformTransactionManager userTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                userEntityManager().getObject());
//
//
//        return transactionManager;
//    }
//
//    @Bean(name="MYSQLDataSource")
//    public DataSource userDataSource() {
//        String driverClassName = env.getProperty(PREFIX+"datasource.driverClassName");
//        String url = env.getProperty(PREFIX+"datasource.url");
//        String username = env.getProperty(PREFIX+"datasource.username");
//        String password = env.getProperty(PREFIX+"datasource.password");
//        System.out.println("DRIVA NAME -> "+ driverClassName);
////        DriverManagerDataSource dataSource
////                = new DriverManagerDataSource();
////        dataSource.setDriverClassName(driverClassName);
////        dataSource.setUrl(url);
////        dataSource.setUsername(username);
////        dataSource.setPassword(password);
//
//        return DataSourceBuilder
//                .create()
//                .username(username)
//                .password(password)
//                .url(url)
//                .driverClassName(driverClassName)
//                .build();
//    }
//
//
//
//
//
//    public Properties hibernateProperties(){
//        final Properties properties = new Properties();
//
////        properties.put("hibernate.connection.driver_class", env.getProperty("db1.datasource.driverClassName"));
////        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//
//        return properties;
//    }
//
//
//
//
//
////    @Bean(name = "mysqlJdbcTemplate")
////    public JdbcTemplate jdbcTemplate(@Qualifier("testDS") DataSource dsMySQL) {
////
//////        new EntityManagerFactory().create
////        return new JdbcTemplate(dsMySQL);
////    }
//
//    @Bean(name="MYSQLEntityManager")
//    public EntityManagerFactory entityManagerFactory(){
//        return userEntityManager().getObject();
//    }
//
//
//
//}
