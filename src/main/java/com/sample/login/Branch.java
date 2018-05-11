package com.sample.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by juliusneria on 19/10/2017.
 */
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long branch_id;

    private String name;

    private String branch;

    private String location;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Book.class, cascade=CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Book> books;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Manager.class, cascade=CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "manager_id")
    private Manager manager;

    protected Branch(){}

    public Long getStore_id() {
        return branch_id;
    }

    public void setStore_id(Long store_id) {
        this.branch_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
