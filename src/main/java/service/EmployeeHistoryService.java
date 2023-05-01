package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeHistoryService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAll(){
        return employeeRepository.findAll();


    }

}
