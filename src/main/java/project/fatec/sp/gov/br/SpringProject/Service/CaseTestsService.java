package project.fatec.sp.gov.br.SpringProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.fatec.sp.gov.br.SpringProject.Domain.CaseTests;
import project.fatec.sp.gov.br.SpringProject.Domain.Problems;
import project.fatec.sp.gov.br.SpringProject.Repository.CaseTestsRepository;
import project.fatec.sp.gov.br.SpringProject.Repository.ProblemsRepository;

@Service
public class CaseTestsService {

    @Autowired
    private CaseTestsRepository repository;

    @Autowired
    private ProblemsRepository problemsRepository;

    public CaseTests findById(Long caseTestId) {
        Optional<CaseTests> found = repository.findById(caseTestId);
        if (found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found.get();
    }
    
    public List<CaseTests> findByProblem(Long problemId) {
        List<CaseTests> results = repository.findByIdProblem(problemId);
        if(results.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); 
        }
        return results;
    }

    public List<CaseTests> findAllTests() {
        return repository.findAll();
    }

    public CaseTests createCaseTest(Long problemId, CaseTests caseTest) {
        Optional<Problems> found = problemsRepository.findById(problemId);

        if (caseTest == null || caseTest.getParams().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(found.isPresent()) {
            Problems founded = found.get();
            caseTest.setProblem(founded);
            return repository.save(caseTest);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Problem not found");
        }
    }

    public void deleteCaseTest(Long caseTestId) {
        repository.deleteById(caseTestId);
    }

}
