package todos.list.infrastructure.dao.todolist;

import todos.list.domain.TodoList;

import java.util.List;

public interface TodoListDao {

    List<TodoList> findAll();

    TodoList findById(Long id);

    TodoList save(TodoList todoList);

    void deleteById(Long id);

}
