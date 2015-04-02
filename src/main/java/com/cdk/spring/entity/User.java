package com.cdk.spring.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by khana on 3/12/2015.
 */

@XmlRootElement
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public User() {
        // default constructor for hibernate.
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
