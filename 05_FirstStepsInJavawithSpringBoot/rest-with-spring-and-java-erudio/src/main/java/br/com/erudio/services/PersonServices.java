package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


import org.springframework.stereotype.Service;

import br.com.erudio.models.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public PersonServices() {}
	
	
	public Person findById(String id) {
		
		logger.info("): Find one person");
				
		Person person = new Person();
		
		person.setId(counter.getAndIncrement());
		person.setFirstName("Alexandre");
		person.setLastName("Ferreira");
		person.setAddress("Rua CAETE - DUQUE DE CAXIAS - RJ");
		person.setGender("Male");
		
		return person;
		
	}
	
	public List<Person> findAll() {
		
		List<Person> persons = new ArrayList<Person>();
		
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	public Person create(Person person) {
		logger.info("): creating new person");
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("): updating person");
		return person;
	}

	public void delete(String id) {
		logger.info("): Deleting one person!");
	}
	
	
	// --------------------------------------
	private Person mockPerson(int i) {
		
		Person person = new Person();
		
		person.setId(counter.getAndIncrement());
		person.setFirstName("Alexandre " + i);
		person.setLastName("Ferreira " + i);
		person.setAddress("Rua CAETE - DUQUE DE CAXIAS - RJ " + i);
		person.setGender("Male");
				
		return person;
	}
	
	
	

}
