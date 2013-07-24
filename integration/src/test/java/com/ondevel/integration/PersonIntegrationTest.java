package com.ondevel.integration;


import com.ondevel.config.WebConfig;
import com.ondevel.dto.PersonDTO;
import com.ondevel.model.Person;
import com.ondevel.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: danielpo
 * Date: 7/23/13
 * Time: 5:57 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class PersonIntegrationTest {

    @Autowired
    PersonService personService;

    @Test
    public void create() {
        PersonDTO dto = new PersonDTO();
        dto.setFirstName("Daniel");
        dto.setLastName("Daniel");
        Person person = personService.create(dto);
    }
}
