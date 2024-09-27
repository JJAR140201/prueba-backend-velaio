package todos.list.infrastructure.mapper;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import todos.list.domain.User;
import todos.list.infrastructure.dto.UserDTO;

public class UserMapper {

    @NotNull
    @Contract("_ -> new")
    public static UserDTO toDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge()
        );
    }

    @NotNull
    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        return user;
    }

}
