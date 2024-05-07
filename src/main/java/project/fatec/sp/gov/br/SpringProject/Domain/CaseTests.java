package project.fatec.sp.gov.br.SpringProject.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "casetests")
public class CaseTests {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCaseTest;

    @Column(name = "result", nullable = false)
    private Boolean result;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "problem_id")
    private Problem problem;

}
