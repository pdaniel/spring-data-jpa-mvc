package com.ondevel.service;

import com.ondevel.dto.PersonDTO;
import com.ondevel.model.Person;

/**
 * @author: danielpo
 * Date: 7/23/13
 * Time: 4:13 PM
 */
public interface PersonService {

    public Person create(PersonDTO personDTO);

}
