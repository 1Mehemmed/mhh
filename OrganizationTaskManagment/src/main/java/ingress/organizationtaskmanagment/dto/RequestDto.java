package ingress.organizationtaskmanagment.dto;

import lombok.Data;


import java.time.LocalDate;
@Data

public class RequestDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}