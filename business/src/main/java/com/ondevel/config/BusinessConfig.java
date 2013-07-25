package com.ondevel.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author danielpo
 *         Date: 7/23/13
 *         Time: 4:04 PM
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.ondevel.service")
@Import(value = BackendConfig.class)
public class BusinessConfig {
    /**
     * Hibernate dialect.
     */
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    /**
     * hibernate format sql.
     */
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    /**
     * Naming strategy.
     */
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    /**
     * Show sql.
     */
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    /**
     * Datasource definition using BoneCPDataSource.
     *
     * @return - a new datasource object
     */
    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass("oracle.jdbc.OracleDriver");
        dataSource.setJdbcUrl("-");
        dataSource.setUsername("-");
        dataSource.setPassword("-");

        return dataSource;
    }

    /**
     * Transaction management definition.
     *
     * @return - a new transaction management instance
     * @throws ClassNotFoundException - exception
     */
    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    /**
     * Create a new entityManagerFactory.
     *
     * @return - the new instance
     * @throws ClassNotFoundException - exception
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.ondevel.model");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

        Properties jpaProterties = new Properties();
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.Oracle10gDialect");
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, true);
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, "org.hibernate.cfg.ImprovedNamingStrategy");
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, true);
        jpaProterties.put("hibernate.hbm2ddl.auto", "update");

        entityManagerFactoryBean.setJpaProperties(jpaProterties);

        return entityManagerFactoryBean;
    }

}
