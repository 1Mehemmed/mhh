package az.ingress.solidprinciplesapplication.SOLID.openclosedprinciple;

import lombok.Data;

import java.util.Date;

@Data
public class DriverLicenseDto {

    private long id;

    private Date issueDate;

    private Date expiredDate;

    private String category;

    private String country;
}
