package todos.list.application.impl.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todos.list.application.service.skill.SkillService;
import todos.list.domain.Skill;
import todos.list.domain.User;
import todos.list.infrastructure.dao.skill.SkillDao;
import todos.list.infrastructure.dao.user.UserDao;
import todos.list.infrastructure.dto.SkillDTO;
import todos.list.infrastructure.mapper.SkillMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillDao skillDao;
    private final UserDao userDao;

    @Override
    public List<SkillDTO> getAllSkills() {
        return skillDao.findAll().stream().map(SkillMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SkillDTO getSkillById(Long id) {
        return SkillMapper.toDto(skillDao.findById(id));
    }

    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = SkillMapper.toEntity(skillDTO);
        User user = userDao.findById(skillDTO.getUserId());
        skill.setUser(user);  // Asigna el usuario a la habilidad
        return SkillMapper.toDto(skillDao.save(skill));
    }

    @Override
    public SkillDTO updateSkill(Long id, SkillDTO skillDTO) {
        Skill skill = skillDao.findById(id);
        skill.setName(skillDTO.getName());
        return SkillMapper.toDto(skillDao.save(skill));
    }

    @Override
    public void deleteSkill(Long id) {
        skillDao.deleteById(id);
    }
}
