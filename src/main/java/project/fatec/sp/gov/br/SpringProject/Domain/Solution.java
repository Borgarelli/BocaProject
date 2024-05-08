package project.fatec.sp.gov.br.SpringProject.Domain;

import java.time.LocalDateTime;
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
import project.fatec.sp.gov.br.SpringProject.Enum.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "solution")
public class Solution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Long id_solution;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "status")
    private Status status;

    @Column(name = "problem_code")
    private String problemCode;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
