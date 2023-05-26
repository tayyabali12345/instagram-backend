package com.example.demo.Services;

import com.example.demo.entities.Employee;
import com.example.demo.jpa.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonServiceJpa {


    private PersonRepository repository;

    public PersonServiceJpa(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getPersons() {
        return repository.findAll();
    }

    public Optional<Employee> getPerson(Long id) {
        Optional<Employee> person =  repository.findById(id);
        return person;

    }

    public Employee verifylogin(Map<Object, Object> loginData){
        Employee employee = repository.findByName((String) loginData.get("username")).orElse(null);
        if (employee.getPassword().equals(loginData.get("password"))){
            return employee;
        }
        return null;
    }



    public void addPerson(Employee person) {

        Employee savedCourse = repository.save(person);

        System.out.print("HELLO WORLD");


    }

}
