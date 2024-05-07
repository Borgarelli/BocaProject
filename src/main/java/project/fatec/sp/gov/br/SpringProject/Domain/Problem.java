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
@Table( name = "problem")
public class Problem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long idProblem;

    @Column(name = "problemName")
    private String problemName;

    @Column(name = "codeProblem", nullable = false, unique = true)
    private String codeProblem;

    @Column(name = "output", nullable = false)
    private Boolean result;

    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CaseTests> caseTests;

}
