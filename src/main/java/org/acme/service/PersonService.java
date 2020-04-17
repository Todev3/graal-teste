package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.model.Person;
import org.acme.repository.PersonRepository;

@ApplicationScoped
public class PersonService {
	
	@Inject
	private PersonRepository personRepository;
	
	public Person findPerson(String name) {
		return personRepository.findByName(name);
	}
	
	@Transactional
	public void create(Person person) {
		personRepository.persist(person);
	}
	
}
