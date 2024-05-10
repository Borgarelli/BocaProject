package project.fatec.sp.gov.br.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.fatec.sp.gov.br.SpringProject.Domain.Solution;
import project.fatec.sp.gov.br.SpringProject.Service.SolutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/solution")
@CrossOrigin
public class SolutionController {

    @Autowired
    private SolutionService service;

    @GetMapping()
    public List<Solution> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Solution getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
    
    @PostMapping()
    public Solution createSolution(@RequestBody Solution solution) {    
        return service.createSolution(solution);
    }
    
    // @GetMapping("/fail")
    // public List<Solution> getByStatus() {
    //     return service.findByStatus();
    // }
    
    @GetMapping("/{problemCode}")
    public List<Solution> getByProblemCode(@PathVariable("problemCode") String problemCode) {
        return service.findByProblemCode(problemCode);
    }
    
    @DeleteMapping("/{id}/delete")
    public void deleteSolution(@PathVariable("id") Long id) {
        service.deleteSolution(id);
    }
}
