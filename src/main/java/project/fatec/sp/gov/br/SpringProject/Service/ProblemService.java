package project.fatec.sp.gov.br.SpringProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.fatec.sp.gov.br.SpringProject.Repository.ProblemRepository;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository repository;
}
