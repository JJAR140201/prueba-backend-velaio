package todos.list.application.impl.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todos.list.application.service.todolist.TodoListService;
import todos.list.domain.TodoList;
import todos.list.domain.User;
import todos.list.infrastructure.dao.todolist.TodoListDao;
import todos.list.infrastructure.dao.user.UserDao;
import todos.list.infrastructure.dto.TodoListDTO;
import todos.list.infrastructure.mapper.TodoListMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {

    private final TodoListDao todoListDao;
    private final UserDao userDao;

    @Override
    public List<TodoListDTO> getAllTodoLists() {
        return todoListDao.findAll().stream().map(TodoListMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TodoListDTO getTodoListById(Long id) {
        return TodoListMapper.toDto(todoListDao.findById(id));
    }

    @Override
    public TodoListDTO createTodoList(TodoListDTO todoListDTO) {
        TodoList todoList = TodoListMapper.toEntity(todoListDTO);
        User user = userDao.findById(todoListDTO.getUserId());
        todoList.setUser(user);  // Asignar usuario
        return TodoListMapper.toDto(todoListDao.save(todoList));
    }

    @Override
    public TodoListDTO updateTodoList(Long id, TodoListDTO todoListDTO) {
        TodoList todoList = todoListDao.findById(id);
        todoList.setName(todoListDTO.getName());
        todoList.setDescription(todoListDTO.getDescription());
        return TodoListMapper.toDto(todoListDao.save(todoList));
    }

    @Override
    public void deleteTodoList(Long id) {
        todoListDao.deleteById(id);
    }
}
