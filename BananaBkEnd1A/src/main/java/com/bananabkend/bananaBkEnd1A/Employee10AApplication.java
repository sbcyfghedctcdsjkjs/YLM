package com.bananabkend.bananaBkEnd1A;

//import com.bananabkend.bananaBkEnd1A.model.Employee;
//import com.bananabkend.bananaBkEnd1A.service.EmployeeService;
import com.bananabkend.bananaBkEnd1A.servlet.DataImageUploadServlet;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Employee10AApplication {

	public static void main(String[] args) {
		SpringApplication.run(Employee10AApplication.class, args);
	}

//        @Bean
//    CommandLineRunner runner(EmployeeService employeeService) {
//        return args -> {
//            employeeService.create(new Employee(1L, "Employee A", 1000.00, LocalDate.parse("2017-11-20")));
//            employeeService.create(new Employee(2L, "Employee B", 10.00, LocalDate.parse("2017-11-21")));
//            employeeService.create(new Employee(3L, "Employee C", 100.00, LocalDate.parse("2017-11-22")));
//            employeeService.create(new Employee(4L, "Employee D", 110.00, LocalDate.parse("2017-11-23")));
//            employeeService.create(new Employee(5L, "Employee E", 100.00, LocalDate.parse("2017-11-24")));
//            employeeService.create(new Employee(6L, "Employee F", 20.00, LocalDate.parse("2017-11-25")));
//            employeeService.create(new Employee(7L, "Employee G", 30.00, LocalDate.parse("2017-11-26")));
//            employeeService.create(new Employee(8L, "Employee H", 500.00, LocalDate.parse("2017-11-27")));
//            employeeService.create(new Employee(9L, "Employee I", 100.00, LocalDate.parse("2017-11-28")));
//            employeeService.create(new Employee(10L, "Employee J",2100.00, LocalDate.parse("2017-11-30")));
//            
//            
//        };
//}
    
      // Register Servlet
//  @Bean
//  public ServletRegistrationBean servletRegistrationBean() {
//    ServletRegistrationBean bean = new ServletRegistrationBean(
//        new DataImageUploadServlet(), "/s1");
//    return bean;
//  }

}
