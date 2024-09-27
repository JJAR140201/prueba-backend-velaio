package todos.list.infrastructure.dao.task;

import org.springframework.data.jpa.repository.JpaRepository;
import todos.list.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
