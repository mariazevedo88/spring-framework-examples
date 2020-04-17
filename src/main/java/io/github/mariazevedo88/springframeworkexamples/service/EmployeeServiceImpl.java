package io.github.mariazevedo88.springframeworkexamples.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mariazevedo88.springframeworkexamples.model.Employee;
import io.github.mariazevedo88.springframeworkexamples.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
