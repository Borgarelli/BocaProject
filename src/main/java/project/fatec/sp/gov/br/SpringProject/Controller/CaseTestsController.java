package project.fatec.sp.gov.br.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.fatec.sp.gov.br.SpringProject.Domain.CaseTests;
import project.fatec.sp.gov.br.SpringProject.Service.CaseTestsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/caseTest")
@CrossOrigin
public class CaseTestsController {

    @Autowired
    private CaseTestsService service;

    @GetMapping
    public List<CaseTests> getAllCaseTests() {
        return service.findAllTests();
    }

    @GetMapping("/{caseTestId}")
    public CaseTests findById(@PathVariable("caseTestId") Long caseTestId) {
        return service.findById(caseTestId);
    }
    
    @PostMapping
    public CaseTests createCaseTest(@PathVariable Long problemId ,@RequestBody CaseTests caseTest) {
        return service.createCaseTest(problemId, caseTest);
    }
    
    @GetMapping("/{problemId}/problem")
    public List<CaseTests> getByProblemId (@PathVariable("problemCode") String problemCode) {
        return service.findByProblem(problemCode);
    }
    
    @DeleteMapping("/{caseTestId}/delete")
    public void deleteById(@PathVariable("caseTestId") Long caseTestId) {
        service.deleteCaseTest(caseTestId);
    }

}
