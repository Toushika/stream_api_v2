package com.enigma.dev;

import com.enigma.dev.model.Employee;
import com.enigma.dev.model.EmployeeDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApiV2Application {

    public static void main(String[] args) {
        SpringApplication.run(StreamApiV2Application.class, args);
        EmployeeDto employeeDto = new EmployeeDto();
        EmployeeDto employeeDto1 = new EmployeeDto();
        EmployeeDto employeeDto2 = new EmployeeDto();
        EmployeeDto employeeDto3 = new EmployeeDto();

        employeeDto.setEmName("toushika");
        employeeDto.setEmAge(26);
        employeeDto.setEmSalary(100000);

        employeeDto1.setEmName("Rupa");
        employeeDto1.setEmAge(23);
        employeeDto1.setEmSalary(30000);

        employeeDto2.setEmName("Rina");
        employeeDto2.setEmAge(14);
        employeeDto2.setEmSalary(232432543);

        employeeDto3.setEmName("Maria");
        employeeDto3.setEmAge(23);
        employeeDto3.setEmSalary(120000);

        List<EmployeeDto> emList = new ArrayList<>();

        emList.add(employeeDto);
        emList.add(employeeDto1);
        emList.add(employeeDto2);
        emList.add(employeeDto3);

        System.out.println("Employee List:: ");
        emList.stream().forEach(x -> System.out.println(x));
        System.out.println();

        System.out.println("Employee List Whose Age is greater than 20");
        emList.stream().filter(x -> x.getEmAge() > 20).forEach(y -> System.out.println(y));
        System.out.println();


        System.out.println("Employee List Whose Age is greater than 23");
        emList.stream().filter(x -> x.getEmAge() > 23).filter(x -> x.getEmName().startsWith("t")).forEach(y -> System.out.println(y));
        System.out.println();

        System.out.println("Employee Highest Age:: ");
        Optional<EmployeeDto> emHighAge = emList.stream().reduce((c1, c2) -> c1.getEmAge() > c2.getEmAge() ? c1 : c2);
        System.out.println(emHighAge);
        System.out.println();

        System.out.println("Show Employee Name Only");
        List<String> emName = emList.stream().map(x -> x.getEmName()).collect(Collectors.toList());
        emName.forEach(y -> System.out.println(y));

        System.out.println("get the summation of sallary:: ");
        int salary = emList.stream().collect(Collectors.summingInt(EmployeeDto::getEmAge));
        System.out.println(salary);

        Employee e1 = new Employee(1, 001, "toushika", 30000);
        Employee e2 = new Employee(2,0001, "Esmerelda",20000);
        Employee e3 = new Employee(3,003,"Tasnim",100000);

        List<Employee> emListInfo = Arrays.asList(e1,e2,e3);
        System.out.println("em List Info:: " +emListInfo);

        int departmentWiseTotalSalary= emListInfo.stream().filter(did->did.getDepId()==001).collect(Collectors.summingInt(Employee::getSalary));

        System.out.println("Total Salary for the department 001---"+departmentWiseTotalSalary);

    }
}
