package todos.list.infrastructure.dao.user;

import todos.list.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

}
