package io.github.mariazevedo88.springframeworkexamples.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mariazevedo88.springframeworkexamples.model.Employee;
import io.github.mariazevedo88.springframeworkexamples.model.EmployeeDTO;
import io.github.mariazevedo88.springframeworkexamples.service.EmployeeService;

@RestController
@RequestMapping("/spring/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO dto) {
		
		Employee employee = employeeService.save(convertDTOToEntity(dto));
		EmployeeDTO response = convertEntityToDTO(employee);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable("id") long id) {
		
		Optional<Employee> opEmployee = employeeService.findById(id);
		
		if(!opEmployee.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
		}
		
		EmployeeDTO response = convertEntityToDTO(opEmployee.get());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
		
		List<Employee> employees = employeeService.findAll();
		
		if(employees.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
		}
		
		List<EmployeeDTO> employeesDTO = new ArrayList<>();
		employees.stream().forEach(i -> employeesDTO.add(convertEntityToDTO(i)));
		
		return new ResponseEntity<>(employeesDTO, HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
		
		Optional<Employee> opEmployee = employeeService.findById(id);
		
		if(!opEmployee.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee doesn't exist.");	
		}
		
		employeeService.deleteById(id);
		return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.NO_CONTENT);
    }
	
	private Employee convertDTOToEntity(EmployeeDTO dto) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Employee.class);
	}
	
	private EmployeeDTO convertEntityToDTO(Employee employee) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(employee, EmployeeDTO.class);
	}

}
