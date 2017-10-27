package com.beans;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "COURS")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cours")
    private Long id;

    private String name;

    private Integer credits;

    @ManyToMany(mappedBy = "cours")
    private List<User> users = new ArrayList<User>();

    public Cours() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
