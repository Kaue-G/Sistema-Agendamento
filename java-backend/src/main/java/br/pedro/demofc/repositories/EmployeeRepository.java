package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee getByEmail(String email);

    Optional<Employee> findByEmail(String email);
}
