package todos.list.application.service.user;

import todos.list.infrastructure.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO saveUser(UserDTO user);

    void deleteUser(Long id);

}
