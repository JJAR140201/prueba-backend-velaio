package todos.list.infrastructure.dao.skill.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import todos.list.domain.Skill;
import todos.list.infrastructure.dao.skill.SkillDao;
import todos.list.infrastructure.dao.skill.SkillRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SkillDaoImpl implements SkillDao {

    private final SkillRepository skillRepository;

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}
