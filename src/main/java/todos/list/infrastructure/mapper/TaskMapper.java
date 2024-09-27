package todos.list.infrastructure.mapper;

import todos.list.domain.Task;
import todos.list.infrastructure.dto.TaskDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskMapper {

    public static TaskDTO toDto(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate().atStartOfDay(),
                task.getCompleted(),
                task.getTodoList().getId(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getSkills() != null ?
                        task.getSkills().stream().map(skill -> skill.getId()).collect(Collectors.toList()) :
                        new ArrayList<>()  // Retorna una lista vacía si skills es null
        );
    }

    // Convierte un TaskDTO a una entidad Task
    public static Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(LocalDate.from(taskDTO.getDueDate()));
        task.setCompleted(taskDTO.getCompleted());
        // La relación con TodoList se maneja separadamente en el servicio
        return task;
    }

    // Actualiza una entidad Task con datos de TaskDTO
    public static Task updateEntity(Task task, TaskDTO taskDTO) {
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(LocalDate.from(taskDTO.getDueDate()));
        task.setCompleted(taskDTO.getCompleted());
        // La relación con TodoList se maneja separadamente en el servicio
        return task;
    }
}
