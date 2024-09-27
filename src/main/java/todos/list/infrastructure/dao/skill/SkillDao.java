package todos.list.infrastructure.dao.skill;

import todos.list.domain.Skill;

import java.util.List;

public interface SkillDao {

    List<Skill> findAll();

    Skill findById(Long id);

    Skill save(Skill skill);

    void deleteById(Long id);

}
