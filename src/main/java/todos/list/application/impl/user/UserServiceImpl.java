package todos.list.application.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todos.list.application.service.user.UserService;
import todos.list.domain.User;
import todos.list.infrastructure.dao.user.UserDao;
import todos.list.infrastructure.dto.UserDTO;
import todos.list.infrastructure.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<UserDTO> getAllUsers() {
        return userDao.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userDao.findById(id);
        return UserMapper.toDto(user);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userDao.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
