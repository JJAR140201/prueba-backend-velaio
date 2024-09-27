package todos.list.infrastructure.dao.task.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import todos.list.domain.Task;
import todos.list.infrastructure.dao.task.TaskDao;
import todos.list.infrastructure.dao.task.TaskRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskDaoImpl implements TaskDao {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
