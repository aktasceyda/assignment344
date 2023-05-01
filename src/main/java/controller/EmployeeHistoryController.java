package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeHistoryService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeHistoryController {
    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeHistoryService.getAll();
    }


}
