package com.ondevel.config;

import com.ondevel.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author: danielpo
 * Date: 7/23/13
 * Time: 4:53 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.ondevel.repository"})
public class BackendConfig {

}
