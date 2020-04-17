package io.github.mariazevedo88.springframeworkexamples.service;

import java.util.List;
import java.util.Optional;

import io.github.mariazevedo88.springframeworkexamples.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	
	Optional<Employee> findById(Long id);
	
	List<Employee> findAll();
	
	void deleteById(Long id);
}
