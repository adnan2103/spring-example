package com.cdk.spring.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by khana on 3/12/2015.
 */

@XmlRootElement
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userId;

    @OneToMany(targetEntity = Setting.class,cascade = CascadeType.ALL)
    private Collection<Setting> settings = new ArrayList<Setting>();

    private String name;


    public User() {
        // default constructor for hibernate.
    }

    public User(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Collection<Setting> getSettings() {
        return settings;
    }

    public void setSettings(Collection<Setting> settings) {
        this.settings = settings;
    }
}
