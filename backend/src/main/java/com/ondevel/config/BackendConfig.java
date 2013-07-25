package com.ondevel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author danielpo
 *         Date: 7/23/13
 *         Time: 4:53 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.ondevel.repository" })
public class BackendConfig {

}
