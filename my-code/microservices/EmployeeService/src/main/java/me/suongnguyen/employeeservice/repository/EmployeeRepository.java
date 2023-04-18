package me.suongnguyen.employeeservice.repository;

import me.suongnguyen.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}