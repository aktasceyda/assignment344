package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.EmployeeRepository;
import service.EmployeeHistoryService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@RestController
public class EmployeeHistoryController {
    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @GetMapping("/connect")
    public String connectToPostgreSQL() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            connection.close();
            return "connect";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/new")
    public String submitForm(@ModelAttribute("employee") Employee employee) {
        employeeHistoryService.calculate(employee);
        return "redirect:/";
    }

}
//önce ön yüz html sonra controller sonra service sonra repository ordan da database e gider.
