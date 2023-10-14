package ingress.organizationtaskmanagment.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    private final ServiceImpl serviceImpl;

    public Controller(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping
    public List<ResponseDto> findAll() {
        return serviceImpl.findAll();
    }

    @PostMapping
    public void create(@RequestBody RequestDto requestDto){
        serviceImpl.createUser(requestDto);
    }
    @GetMapping("/{id}")
    public ResponseDto getUserById(@PathVariable Long id){
        return serviceImpl.getUserById(id);

    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestDto requestDto){
        serviceImpl.update(id,requestDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serviceImpl.delete(id);
    }

}


public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    // Дополнительные методы могут быть добавлены по необходимости
}

public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, ModelMapper modelMapper) {
        this.organizationRepository = organizationRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrganizationDTO> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations.stream()
                .map(org -> modelMapper.map(org, OrganizationDTO.class))
                .collect(Collectors.toList());
    }

    public OrganizationDTO getOrganizationById(Long id) {
        Optional<Organization> organizationOptional = organizationRepository.findById(id);
        if (organizationOptional.isPresent()) {
            return modelMapper.map(organizationOptional.get(), OrganizationDTO.class);
        } else {
            throw new EntityNotFoundException("Organization not found");
        }
    }

    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = modelMapper.map(organizationDTO, Organization.class);
        Organization savedOrganization = organizationRepository.save(organization);
        return modelMapper.map(savedOrganization, OrganizationDTO.class);
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}

// Controller: OrganizationController.java

@RequestMapping("/organizations")

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

}
