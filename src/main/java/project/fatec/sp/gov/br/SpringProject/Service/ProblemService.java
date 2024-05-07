package project.fatec.sp.gov.br.SpringProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.fatec.sp.gov.br.SpringProject.Domain.Problem;
import project.fatec.sp.gov.br.SpringProject.Repository.ProblemRepository;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository repository;

    public Problem createProblem(Problem problem) {
        if(problem == null || problem.getCodeProblem().isBlank()
        || problem.getProblemName().isBlank()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return repository.save(problem);
    }

    public Problem findById(Long id) {
        Optional<Problem> found = repository.findById(id);
        if(found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found.get();
    }

    public List<Problem> findAllProblems() {
        return repository.findAll();
    }


}
