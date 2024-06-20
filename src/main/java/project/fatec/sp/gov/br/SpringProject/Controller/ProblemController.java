package project.fatec.sp.gov.br.SpringProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.fatec.sp.gov.br.SpringProject.Domain.Problems;
import project.fatec.sp.gov.br.SpringProject.Service.ProblemsService;

import java.util.List;

@RestController
@RequestMapping("/problem")
@CrossOrigin
public class ProblemController {

    @Autowired
    private ProblemsService service;

    @GetMapping
    public List<Problems> getAllProblems() {
        return service.findAllProblems();
    }

    @GetMapping("/{problemId}")
    public Problems getById(@PathVariable("problemId") Long problemId) {
        return service.findById(problemId);
    }

    @PostMapping
    public Problems createNewProblem(@RequestBody Problems problem) {
        return service.newProblems(problem);
    }
    
    @DeleteMapping("/{problemId}")
    public void deleteProblem(@PathVariable("problemId") Long problemId) {
        service.deleteProblem(problemId);
    }

}
