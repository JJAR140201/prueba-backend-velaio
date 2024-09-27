package todos.list.application.service.todolist;

import todos.list.infrastructure.dto.TodoListDTO;

import java.util.List;

public interface TodoListService {

    List<TodoListDTO> getAllTodoLists();

    TodoListDTO getTodoListById(Long id);

    TodoListDTO createTodoList(TodoListDTO todoListDTO);

    TodoListDTO updateTodoList(Long id, TodoListDTO todoListDTO);

    void deleteTodoList(Long id);

}
