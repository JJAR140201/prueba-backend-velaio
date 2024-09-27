package todos.list.infrastructure.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todos.list.application.service.user.UserService;
import todos.list.infrastructure.dto.UserDTO;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "Operaciones relacionadas con la gestión de usuarios")
public class UserController {

    private final UserService userService;

    // Obtener todos los usuarios
    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios registrados")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Devuelve un usuario según el ID proporcionado")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Crear un nuevo usuario
    @PostMapping
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario con los datos proporcionados")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario por ID", description = "Elimina un usuario según el ID proporcionado")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
