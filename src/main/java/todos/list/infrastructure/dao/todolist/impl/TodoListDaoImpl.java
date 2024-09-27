package todos.list.infrastructure.dao.todolist.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import todos.list.domain.TodoList;
import todos.list.infrastructure.dao.todolist.TodoListDao;
import todos.list.infrastructure.dao.todolist.TodoListRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoListDaoImpl implements TodoListDao {

    private final TodoListRepository todoListRepository;

    @Override
    public List<TodoList> findAll() {
        return (List<TodoList>) todoListRepository.findAll();
    }

    @Override
    public TodoList findById(Long id) {
        return todoListRepository.findById(id).orElse(null);
    }

    @Override
    public TodoList save(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public void deleteById(Long id) {
        todoListRepository.deleteById(id);
    }
}
