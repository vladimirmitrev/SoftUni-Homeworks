package hiberspring.repository;

import hiberspring.domain.dtos.EmployeeExportDto;
import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT e FROM Employee e" +
            " WHERE e.branch.name IS NOT NULL" +
            " AND e.branch.products.size > 0" +
            " ORDER BY e.firstName, e.lastName, length(e.position) DESC")
    List<Employee> findAllEmployeesWithBranchAndProduct();


//    @Query("select new hiberspring.domain.dtos.EmployeeExportDto (" +
//            "concat(e.firstName, ' ', e.lastName), e.position, ec.number)" +
//            " FROM Employee as e" +
//            " JOIN EmployeeCard as ec on ec.id = e.card.id" +
//            " JOIN Branch as b on b.id = e.branch.id" +
//            " JOIN Product as p on b.id = p.branch.id" +
//            " WHERE p.branch.id is not null" +
//            " ORDER BY concat(e.firstName, ' ', e.lastName), length(e.position) desc")
//    List<EmployeeExportDto> findAllEmployeeWithProduct();


}
