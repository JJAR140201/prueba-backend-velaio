package todos.list.infrastructure.controller.task;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todos.list.application.service.task.TaskService;
import todos.list.infrastructure.dto.TaskDTO;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Tag(name = "Task Management", description = "Operaciones relacionadas con la gestión de tareas")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista de todas las tareas registradas")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID", description = "Devuelve una tarea según el ID proporcionado")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva tarea", description = "Crea una nueva tarea con los datos proporcionados")
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una tarea", description = "Actualiza una tarea existente según el ID proporcionado")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea por ID", description = "Elimina una tarea según el ID proporcionado")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/{taskId}/assign/{userId}")
    @Operation(summary = "Asignar una tarea a un usuario", description = "Asigna una tarea a un usuario según el ID de la tarea y el ID del usuario")
    public void assignTaskToUser(@PathVariable Long taskId, @PathVariable Long userId) {
        taskService.assignTaskToUser(taskId, userId);
    }

}
