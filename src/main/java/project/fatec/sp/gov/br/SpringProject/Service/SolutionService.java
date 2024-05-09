package project.fatec.sp.gov.br.SpringProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.fatec.sp.gov.br.SpringProject.Domain.Solution;
import project.fatec.sp.gov.br.SpringProject.Repository.SolutionRepository;

@Service
public class SolutionService {

    @Autowired
    private SolutionRepository repository;

    public Solution createSolution(Solution solution) {
        String fileType = ".py";

        if(solution == null || solution.getFileName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(!solution.getFileName().contains(fileType)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Send a python file only!");
        }

        return repository.save(solution);
    }

    public Solution findById(Long id) {
        Optional<Solution> found = repository.findById(id);
        if(found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found.get();
    }

    public List<Solution> findAll() {
        return repository.findAll();
    }

    public void deleteSolution(Long id) {
        repository.deleteById(id);
    }

    public List<Solution> findByStatus() {
        List<Solution> found = repository.findByStatus();
        if(found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found;
    }
     
    public List<Solution> findByProblemCode(String problemCode) {
        List<Solution> found = repository.findByProblemCodeOrderByCreatedAt(problemCode);
        if(found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found;
    }
}
