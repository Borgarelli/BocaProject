package project.fatec.sp.gov.br.SpringProject.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import project.fatec.sp.gov.br.SpringProject.Domain.Solution;
import project.fatec.sp.gov.br.SpringProject.Service.SolutionService;

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

    @PostMapping("/upload")
    public ResponseEntity<Solution> uploadSolution(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File or solution cannot be null");
            }

            Solution createdSolution = service.createSolution(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSolution);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create solution", e);
        }
    }

    // @GetMapping("/fail")
    // public List<Solution> getByStatus() {
    //     return service.findByStatus();
    // }
    
    // @GetMapping("/{problemId}")
    // public List<Solution> getByProblemId(@PathVariable("problemId") Long problemId) {
    //     return service.findByProblemCode(problemId);
    // }

    @DeleteMapping("/{id}/delete")
    public void deleteSolution(@PathVariable("id") Long id) {
        service.deleteSolution(id);
    }
}