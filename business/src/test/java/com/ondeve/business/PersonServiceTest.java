package com.ondeve.business;

import com.ondevel.dto.PersonDTO;
import com.ondevel.model.Person;
import com.ondevel.repository.PersonRepository;
import com.ondevel.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * @author: danielpo
 * Date: 7/23/13
 * Time: 5:33 PM
 */
public class PersonServiceTest {
    private PersonServiceImpl personService;
    private PersonRepository personRepositoryMock;

    @Before
    public void setup() {
        personService = new PersonServiceImpl();
        personRepositoryMock = mock(PersonRepository.class);
        personService.setPersonRepository(personRepositoryMock);
    }

    @Test
    public void create() {
        PersonDTO dto = new PersonDTO();
        dto.setFirstName("Daniel");
        dto.setLastName("Daniel");
        Person person = new Person();
        person.setFirstName("Daniel");
        person.setLastName("Daniel");
        person.setId(5L);
        when(personRepositoryMock.save(any(Person.class))).thenReturn(person);
        Person returned = personService.create(dto);
        System.out.println(returned);
    }
}
