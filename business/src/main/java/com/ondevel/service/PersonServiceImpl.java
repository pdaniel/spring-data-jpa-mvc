package com.ondevel.service;

import com.ondevel.dto.PersonDTO;
import com.ondevel.model.Person;
import com.ondevel.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author danielpo
 * Date: 7/23/13
 * Time: 4:13 PM
 */
@Service
@Transactional
class PersonServiceImpl implements PersonService {
    /**
     * Logger constant.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    /**
     * Person repository.
     */
    @Resource
    private PersonRepository personRepository;

    @Override
    public Person create(final PersonDTO personDTO) {
        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        return personRepository.save(person);
    }

    /**
     * Setter for person repository to be used only from tests.
     * @param personRepo - a new person repository
     */
    public void setPersonRepository(final PersonRepository personRepo) {
        this.personRepository = personRepo;
    }
}
