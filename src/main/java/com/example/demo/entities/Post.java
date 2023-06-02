package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String URI;

    public Post() {
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", employee=" + employee +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Employee getEmployee() {
        return employee;
    }

    // Many-to-one relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Post(Long id, String content, String URI,Employee employee) {
        this.id = id;
        this.URI = URI;
        this.content = content;
        this.employee = employee;
    }
}
