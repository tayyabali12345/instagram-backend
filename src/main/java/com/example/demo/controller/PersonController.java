package com.example.demo.controller;

import com.example.demo.Services.PersonServiceJpa;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class





PersonController {

    @Autowired
    private PersonServiceJpa personservicejpa;

    @PostMapping("/login")
    public Employee verifyPerson(@RequestBody Map<Object, Object> loginData){
        Employee employee = personservicejpa.verifylogin(loginData);
        return employee;
    }

    @PostMapping("/signup")
    public int savedPerson(@RequestBody Map<Object, Object> signupData){
        return personservicejpa.saveUser(signupData);
    }




    @PostMapping(value = "/storeImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Post savedImage(@RequestParam MultipartFile file, @RequestParam("user") String userData ){

       Post temp = personservicejpa.saveImage(file, userData);
       System.out.println(temp);
       return temp;

    }

    @GetMapping("/persons")
    public List<Employee> getCourses(){
        return this.personservicejpa.getPersons();
    }

    @GetMapping("/persons/{personid}")
    public Optional<Employee> getPerson(@PathVariable Long personid){
            return this.personservicejpa.getPerson(personid);
    }

    @PostMapping("/courses")
    public void addPerson(@RequestBody Employee person){
        this.personservicejpa.addPerson(person);
    }

}
