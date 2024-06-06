package project.fatec.sp.gov.br.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import project.fatec.sp.gov.br.SpringProject.Domain.Solution;
import project.fatec.sp.gov.br.SpringProject.Enum.Status;
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

    @PostMapping("/upload/{problemId}")
    public ResponseEntity<Solution> uploadSolution(@RequestPart("file") MultipartFile file, @RequestPart("data") Solution solution, @PathVariable("problemId") Long problemId) {
        try {
            if (file.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File or solution cannot be null");
            }

            Solution createdSolution = service.createSolution(file, solution, problemId);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSolution);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create solution", e);
        }
    }

     @GetMapping("/{status}")
     public List<Solution> getByStatus(@PathVariable("status") Status status) {
         return service.findByStatus(status);
     }
    
     @GetMapping("/{problemId}/problems")
     public List<Solution> getByProblemId(@PathVariable("problemId") Long problemId) {
         return service.findByProblemId(problemId);
     }

    @DeleteMapping("/{id}/delete")
    public void deleteSolution(@PathVariable("id") Long id) {
        service.deleteSolution(id);
    }

}