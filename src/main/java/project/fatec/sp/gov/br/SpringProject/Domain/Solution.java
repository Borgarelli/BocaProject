package project.fatec.sp.gov.br.SpringProject.Domain;

import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "problem_id")
    @JsonIgnore
    private Problems problem;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
