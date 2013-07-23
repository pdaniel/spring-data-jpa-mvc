package com.ondevel.repository;

import com.ondevel.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: danielpo
 * Date: 7/23/13
 * Time: 4:58 PM
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

}
