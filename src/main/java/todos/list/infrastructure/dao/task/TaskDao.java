package todos.list.infrastructure.dao.task;

import todos.list.domain.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAll();

    Task findById(Long id);

    Task save(Task task);

    void deleteById(Long id);

}
