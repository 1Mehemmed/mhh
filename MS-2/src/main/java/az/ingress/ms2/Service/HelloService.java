package az.ingress.ms2.Service;

import az.ingress.ms2.dto.XDto;
import org.springframework.stereotype.Service;

@Service
public interface HelloService {
    XDto sayHello1(String language);
    XDto sayHello2();
    XDto sayHello3();
}
