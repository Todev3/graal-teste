package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.Person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
	
	public Person findByName(String name){
		return find("name", name).firstResult();
	}
	
}
