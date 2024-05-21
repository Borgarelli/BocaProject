package project.fatec.sp.gov.br.SpringProject.Enum;

import lombok.Getter;

@Getter
public enum Status {
    
    SUCCESS("Sucess"),
    FAIL("Fail");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
