package project.fatec.sp.gov.br.SpringProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.fatec.sp.gov.br.SpringProject.Service.ProblemsService;

@RestController
@RequestMapping("/problem")
@CrossOrigin
public class ProblemController {

    @Autowired
    private ProblemsService service;
}
