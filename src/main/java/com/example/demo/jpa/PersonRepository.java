package com.example.demo.jpa;
import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByName(String name);


}