package project.fatec.sp.gov.br.SpringProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import project.fatec.sp.gov.br.SpringProject.Domain.Solution;

import java.util.List;

public interface SolutionRepository extends JpaRepository <Solution,Long>{

    @Query("SELECT s FROM Solution s " +
            "LEFT JOIN s.problem p " +
            "WHERE p.idProblem = :problemId " +
            "ORDER BY s.createdAt ")
    List<Solution> findByIdProblem(Long problemId);

}
