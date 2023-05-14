package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;

public class EmployeeHistoryServiceImpl implements EmployeeHistoryService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public EmployeeHistoryServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void calculate(Employee employee) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Users").usingColumns("firstName","lastName","dateOfBirth","gender","weight","height");
        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(employee);
        insertActor.execute(param);
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
