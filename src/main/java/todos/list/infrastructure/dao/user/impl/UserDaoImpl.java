package todos.list.infrastructure.dao.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import todos.list.domain.User;
import todos.list.infrastructure.dao.user.UserDao;
import todos.list.infrastructure.dao.user.UserRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
