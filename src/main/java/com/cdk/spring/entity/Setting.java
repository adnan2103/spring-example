package com.cdk.spring.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by khana on 4/2/15.
 */

@Entity
@Table(name = "setting")
public class Setting {

    @Id
    @GeneratedValue
    @Column(name="setting_id")
    private Long settingId;

    private String name;

    private String value;

    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Setting() {
    }

    public Setting(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Long getSettingId() {
        return settingId;
    }

    public void setSettingId(Long settingId) {
        this.settingId = settingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
