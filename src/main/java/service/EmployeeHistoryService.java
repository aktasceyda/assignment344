package service;

import model.Employee;

import java.util.List;

public interface EmployeeHistoryService {
    public void calculate(Employee employee);
    public List<Employee> findAll();
}
