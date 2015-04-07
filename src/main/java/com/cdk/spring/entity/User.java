package com.cdk.spring.entity;

import javax.persistence.*;

/**
 * Created by khana on 3/12/2015.
 */

@IdClass(UserPrimaryKey.class)
@Entity
public class User {

    @Id
    private Long id;

    @Id
    private String name;

    public User() {
        // default constructor for hibernate.
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
