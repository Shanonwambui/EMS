package com.example.ems1;

import com.example.ems1.model.Employee;
import com.example.ems1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ems1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Ems1Application.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Shanon");
        employee.setLastName("Wambui");
        employee.setEmailId("Shanonwambui@gmail.com");
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Jane");
        employee1.setLastName("Doe");
        employee1.setEmailId("JaneDoe@gmail.com");
        employeeRepository.save(employee1);


    }
}
