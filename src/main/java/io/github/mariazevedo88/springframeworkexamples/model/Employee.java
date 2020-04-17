package io.github.mariazevedo88.springframeworkexamples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Entity
@Primary
@Component
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;

	@Column(name="level")
	private String level;
	
	public Employee() {}

    @Autowired
    public Employee(String level) {
        this.level = level;
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

	@Autowired
    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
