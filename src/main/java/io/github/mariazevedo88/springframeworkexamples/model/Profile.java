package io.github.mariazevedo88.springframeworkexamples.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Value("1")
    private int numberOfDepartments;

    @Value("${profile.level}")
    private String profileLevel;

    public Profile() {
        this(1);
    }

    public Profile(@Value("1") int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }

    @Value("1")
    public void setNumberOfDepartments(int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }

}




