package project.fatec.sp.gov.br.SpringProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.fatec.sp.gov.br.SpringProject.Service.SolutionService;

@RestController
@RequestMapping("/solution")
@CrossOrigin
public class SolutionController {

    @Autowired
    private SolutionService service;

}
