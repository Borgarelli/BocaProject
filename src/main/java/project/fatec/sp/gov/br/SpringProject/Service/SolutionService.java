package project.fatec.sp.gov.br.SpringProject.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import project.fatec.sp.gov.br.SpringProject.Domain.CaseTests;
import project.fatec.sp.gov.br.SpringProject.Domain.Problems;
import project.fatec.sp.gov.br.SpringProject.Domain.Solution;
import project.fatec.sp.gov.br.SpringProject.Enum.Status;
import project.fatec.sp.gov.br.SpringProject.Repository.CaseTestsRepository;
import project.fatec.sp.gov.br.SpringProject.Repository.ProblemsRepository;
import project.fatec.sp.gov.br.SpringProject.Repository.SolutionRepository;

@Service
public class SolutionService {

   @Autowired
   private SolutionRepository repository;

   @Autowired
   private ProblemsRepository problemsRepository;

    @Autowired
    private CaseTestsRepository caseTestsRepository;

    public Solution createSolution(MultipartFile file, Solution solution, Long problemId) {

        if(file == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".py")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Send a python file only!");
        }
        

        try {
            Path tempFilePath = Files.createTempFile("uploaded-file", ".py");
            Files.copy(file.getInputStream(), tempFilePath, StandardCopyOption.REPLACE_EXISTING);

            solution.setProblem(problemsRepository.findById(problemId).get());
            solution.setFileName(file.getOriginalFilename());

            Solution savedSolution = repository.save(solution);
            executePythonFile(savedSolution.getProblem().getIdProblem(), tempFilePath.toString());
            savedSolution.setStatus(Status.SUCCESS);
            savedSolution.setCreatedAt(LocalDateTime.now());
            return savedSolution;
        }
        catch (IOException e) {
            solution.setStatus(Status.FAIL);
            return repository.save(solution);
        }
    }

    public Solution findById(Long id) {
        Optional<Solution> found = repository.findById(id);
        if(found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return found.get();
    }

    private void executePythonFile(Long problemId, String pythonCode) {
        List<CaseTests> found = caseTestsRepository.findByIdProblem(problemId);

        for(CaseTests founded : found) {
            String pythonOutput = executePythonCode(pythonCode, problemId, founded.getParams());

            if(!pythonOutput.trim().equals(founded.getResult().trim())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fail test");
            }
        }
    }

    private String executePythonCode(String pythonCodeFilePath, Long problemId, String input) {
        StringBuilder output = new StringBuilder();
        try {
            String[] command = new String[]{"python3", pythonCodeFilePath, String.valueOf(problemId), input};

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                throw new RuntimeException("Erro ao executar o código Python");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao executar o código Python: " + e.getMessage());
        }
        return output.toString();
    }

    public List<Solution> findAll() {
        return repository.findAll();
    }

    public void deleteSolution(Long id) {
        repository.deleteById(id);
    }

    // public List<Solution> findByStatus() {
    //     List<Solution> found = repository.findByStatus();
    //     if(found.isEmpty()) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    //     }
    //     return found;
    // }
     
    // public List<Solution> findByProblemCode(Long problemId) {
    //     List<Solution> found = repository.findByProblemIdOrderByCreatedAt(problemId);
    //     if(found.isEmpty()) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    //     }
    //     return found;
    // }
}
