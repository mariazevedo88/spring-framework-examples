package io.github.mariazevedo88.springframeworkexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mariazevedo88.springframeworkexamples.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
