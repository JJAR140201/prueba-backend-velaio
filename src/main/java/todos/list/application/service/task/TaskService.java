package todos.list.application.service.task;

import todos.list.infrastructure.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getAllTasks();

    TaskDTO getTaskById(Long id);

    TaskDTO createTask(TaskDTO taskDTO);

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);

    void assignTaskToUser(Long taskId, Long userId);

}
