package project.fatec.sp.gov.br.SpringProject.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "problems")
public class Problems {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long idProblem;

    @Column(name = "problem_name")
    private String problemName;

    @Column(name = "code_problem", nullable = false, unique = true)
    private String codeProblem;

    @Column(name = "output", nullable = false)
    private Boolean result;

    // @OneToMany(mappedBy = "caseTests", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // private List<CaseTests> caseTests;

}
