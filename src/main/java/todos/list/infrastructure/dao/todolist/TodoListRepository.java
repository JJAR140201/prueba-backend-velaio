package todos.list.infrastructure.dao.todolist;

import org.springframework.data.repository.CrudRepository;
import todos.list.domain.TodoList;

public interface TodoListRepository extends CrudRepository<TodoList, Long> {
}
