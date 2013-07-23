package com.ondevel.context;

import com.ondevel.config.BackendConfig;
import com.ondevel.config.BusinessConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author: danielpo
 * Date: 7/23/13
 * Time: 5:56 PM
 */
@Configuration
//@ComponentScan(basePackages = {"com.toptoolz"})
@Import(value = {BusinessConfig.class, BackendConfig.class})
public class ApplicationContext {
    /**
     * The bean configures the message bundle for internationalization
     *
     * @return - message bundle
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


}
