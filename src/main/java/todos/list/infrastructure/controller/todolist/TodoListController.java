package todos.list.infrastructure.controller.todolist;

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
import todos.list.application.service.todolist.TodoListService;
import todos.list.infrastructure.dto.TodoListDTO;

import java.util.List;

@RestController
@RequestMapping("/todolists")
@CrossOrigin("*")
@RequiredArgsConstructor
@Tag(name = "TodoList Management", description = "Operaciones relacionadas con la gestión de listas de tareas")
public class TodoListController {

    private final TodoListService todoListService;

    @GetMapping
    @Operation(summary = "Obtener todas las listas de tareas", description = "Devuelve una lista de todas las listas de tareas registradas")
    public List<TodoListDTO> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una lista de tareas por ID", description = "Devuelve una lista de tareas según el ID proporcionado")
    public TodoListDTO getTodoListById(@PathVariable Long id) {
        return todoListService.getTodoListById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva lista de tareas", description = "Crea una nueva lista de tareas con los datos proporcionados")
    public TodoListDTO createTodoList(@RequestBody TodoListDTO todoListDTO) {
        return todoListService.createTodoList(todoListDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una lista de tareas", description = "Actualiza una lista de tareas existente según el ID proporcionado")
    public TodoListDTO updateTodoList(@PathVariable Long id, @RequestBody TodoListDTO todoListDTO) {
        return todoListService.updateTodoList(id, todoListDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una lista de tareas por ID", description = "Elimina una lista de tareas según el ID proporcionado")
    public void deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
    }

}
