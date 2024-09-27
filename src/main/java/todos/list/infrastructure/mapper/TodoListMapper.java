package todos.list.infrastructure.mapper;

import todos.list.domain.TodoList;
import todos.list.infrastructure.dto.TodoListDTO;

public class TodoListMapper {

    public static TodoListDTO toDto(TodoList todoList) {
        return new TodoListDTO(
                todoList.getId(),
                todoList.getName(),
                todoList.getDescription(),
                todoList.getUser().getId()
        );
    }

    public static TodoList toEntity(TodoListDTO todoListDTO) {
        TodoList todoList = new TodoList();
        todoList.setId(todoListDTO.getId());
        todoList.setName(todoListDTO.getName());
        todoList.setDescription(todoListDTO.getDescription());
        // La relación con el usuario se maneja en el servicio.
        return todoList;
    }

}
