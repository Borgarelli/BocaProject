package project.fatec.sp.gov.br.SpringProject.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import project.fatec.sp.gov.br.SpringProject.Domain.Solution;
import java.util.List;

public interface SolutionRepository extends JpaRepository <Solution,Long>{


}
