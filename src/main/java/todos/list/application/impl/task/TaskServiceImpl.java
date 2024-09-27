package todos.list.application.impl.task;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import todos.list.application.service.task.TaskService;
import todos.list.domain.Task;
import todos.list.domain.TodoList;
import todos.list.domain.User;
import todos.list.infrastructure.dao.task.TaskDao;
import todos.list.infrastructure.dao.todolist.TodoListDao;
import todos.list.infrastructure.dao.user.UserDao;
import todos.list.infrastructure.dto.TaskDTO;
import todos.list.infrastructure.mapper.TaskMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    private final TaskDao taskDao;
    private final UserDao userDao;
    private final TodoListDao todoListDao;

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskDao.findAll().stream().map(TaskMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskDao.findById(id);
        return TaskMapper.toDto(task);
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        logger.info("Creando tarea con el título: {}", taskDTO.getTitle());

        TodoList todoList = todoListDao.findById(taskDTO.getTodoList());
        if (todoList == null) {
            logger.error("No se encontró la lista de tareas con ID: {}", taskDTO.getTodoList());
            throw new IllegalArgumentException("Lista de tareas no encontrada.");
        }

        // Obtener el usuario relacionado
        User user = userDao.findById(todoList.getUser().getId());
        if (user == null) {
            logger.error("No se encontró el usuario con ID: {}", todoList.getUser().getId());
            throw new IllegalArgumentException("Usuario no encontrado.");
        }

        Task task = TaskMapper.toEntity(taskDTO);
        task.setTodoList(todoList);
        task.setUser(user);  // Asignar el usuario a la tarea

        logger.info("Tarea mapeada, lista para guardar: {}", task);
        Task savedTask = taskDao.save(task);
        logger.info("Tarea guardada con éxito con ID: {}", savedTask.getId());

        return TaskMapper.toDto(savedTask);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskDao.findById(id);
        Task updatedTask = TaskMapper.updateEntity(task, taskDTO);
        return TaskMapper.toDto(taskDao.save(updatedTask));
    }

    @Override
    public void deleteTask(Long id) {
        taskDao.deleteById(id);
    }

    @Override
    public void assignTaskToUser(Long taskId, Long userId) {
        Task task = taskDao.findById(taskId);
        User user = userDao.findById(userId);
        task.setUser(user);
        taskDao.save(task);
    }
}
