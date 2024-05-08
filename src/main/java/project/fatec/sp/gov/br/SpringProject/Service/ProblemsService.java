package project.fatec.sp.gov.br.SpringProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.fatec.sp.gov.br.SpringProject.Domain.Problems;
import project.fatec.sp.gov.br.SpringProject.Repository.ProblemsRepository;

@Service
public class ProblemsService {

    @Autowired
    private ProblemsRepository repository;

    public Problems newProblems(Problems problems) {
        if(problems == null || problems.getCodeProblem().isBlank()
                || problems.getProblemName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return repository.save(problems);
    }

    public Problems findById(Long id) {
        Optional<Problems> found = repository.findById(id);
        if (found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found.get();
    }

    public List<Problems> findAllProblems() {
        return repository.findAll();
    }

}
