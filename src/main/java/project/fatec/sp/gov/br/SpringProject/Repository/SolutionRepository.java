package project.fatec.sp.gov.br.SpringProject.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import project.fatec.sp.gov.br.SpringProject.Domain.Solution;

public interface SolutionRepository extends JpaRepository <Solution,Long>{

    // @Query("SELECT s FROM Solution s " +
    // "WHERE s.status = Falso")
    // public List<Solution> findByStatus();

    List<Solution> findByProblemCodeOrderByCreatedAt(String problemCode);

}
