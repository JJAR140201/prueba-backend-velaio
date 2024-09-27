package todos.list.infrastructure.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import todos.list.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
