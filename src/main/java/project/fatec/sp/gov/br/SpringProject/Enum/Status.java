package project.fatec.sp.gov.br.SpringProject.Enum;

import lombok.Getter;

@Getter
public enum Status {
    
    SUCESSO("Sucesso"),
    FALSO("Falso");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
