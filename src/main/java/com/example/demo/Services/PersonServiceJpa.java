package com.example.demo.Services;

import com.cloudinary.Cloudinary;
import com.example.demo.config.CloudinaryConfig;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Post;
import com.example.demo.jpa.PersonRepository;
import com.example.demo.jpa.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.utils.StringUtils;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.api.ApiResponse;

@Service
public class PersonServiceJpa {
    private PersonRepository repository;
    @Autowired
    private PostRepository postRep;


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

    public Post saveImage(@RequestBody MultipartFile imageData, @RequestParam("user") String userData ){

        try {
            String location = "/home/dev/Documents/";
            String filename = imageData.getOriginalFilename();
            String filepath = location + filename;
            imageData.transferTo(new File(filepath));
            System.out.println("File location: " + filepath);

            Cloudinary cloudinary = CloudinaryConfig.getInstance();
            File imageFile = new File(filepath);
            Map<?, ?> uploadResult = cloudinary.uploader().upload(imageFile, ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("secure_url");

            System.out.println("Image uploaded successfully. URL: " + imageUrl);

            if (imageFile.exists()) {
                if (imageFile.delete()) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File does not exist at the specified location.");
            }
            Optional<Employee> optionalUser = repository.findById(Long.valueOf(userData));
            if (optionalUser.isPresent()) {
                Employee user = optionalUser.get();

                Post post = new Post();
                post.setContent("This post is about Universal Trend");
                post.setEmployee(user);
                post.setURI(imageUrl);
                postRep.save(post);
                return post;

            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }

    }

    public int saveUser(Map<Object, Object> signupData){
        Employee employee = repository.findByName((String) signupData.get("name")).orElse(null);
        if (employee == null){
            Employee saveEmployee= new Employee((String) signupData.get("password"), (String) signupData.get("name"));
            Employee save = repository.save(saveEmployee);
            System.out.println(save);
            return (int)save.getId();
        }
        return 0;
    }

    public void addPerson(Employee person) {
        Employee savedCourse = repository.save(person);
    }

}
