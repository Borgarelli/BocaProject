package project.fatec.sp.gov.br.SpringProject.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "problem")
public class Problem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProblem;

    @Column(name = "ProblemName")
    private String problemName;

    @Column(name = "codeProblem", nullable = false, unique = true)
    private String codeProblem;

    @Column(name = "output")
    private Boolean result;

}
