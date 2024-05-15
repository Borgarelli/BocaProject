package project.fatec.sp.gov.br.SpringProject.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.fatec.sp.gov.br.SpringProject.Enum.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test")
public class CaseTests {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_test_id")
    private long idCaseTest;

    @Column(name = "result")
    private Status result;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "problem_id")
    @JsonIgnore
    private Problems problem;

}
