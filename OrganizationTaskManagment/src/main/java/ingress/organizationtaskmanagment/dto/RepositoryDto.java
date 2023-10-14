package ingress.organizationtaskmanagment.dto;

import ingress.organizationtaskmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDto extends JpaRepository<User,Long> {
}
