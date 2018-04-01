package net.licenta.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = "net.licenta.spring")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
                HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
                vendorAdapter.setGenerateDdl(true);

                LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
                factory.setJpaVendorAdapter(vendorAdapter);
                factory.setPackagesToScan("ro.nttdata.bv.parking.entity");
                factory.setDataSource(dataSource());
                factory.afterPropertiesSet();

                return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
                JpaTransactionManager txManager = new JpaTransactionManager();
                txManager.setEntityManagerFactory(entityManagerFactory());
                return txManager;
            }
}

