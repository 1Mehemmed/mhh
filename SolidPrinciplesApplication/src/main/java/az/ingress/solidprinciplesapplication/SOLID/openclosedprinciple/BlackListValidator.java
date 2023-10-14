package az.ingress.solidprinciplesapplication.SOLID.openclosedprinciple;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlackListValidator implements AbstractValidator {
    private List blackList =List.of(1861070L,1861080L,1982323L);

    @Override
    public boolean isValid(DriverLicenseDto dto) {
        boolean contains = blackList.contains(dto.getId());
        if (contains)
            return false;
        return true;
    }
}
