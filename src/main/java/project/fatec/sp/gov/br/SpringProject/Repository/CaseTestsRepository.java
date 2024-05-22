package project.fatec.sp.gov.br.SpringProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.fatec.sp.gov.br.SpringProject.Domain.CaseTests;

import java.util.List;

public interface CaseTestsRepository extends JpaRepository<CaseTests, Long> {

    @Query("SELECT c FROM CaseTests c " +
            "LEFT JOIN c.problem p " +
            "WHERE p.problem_code = :problemCode ")
    List<CaseTests> findByCodeProblem(String problemCode);

}
