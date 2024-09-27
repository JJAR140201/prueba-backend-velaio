package todos.list.infrastructure.dao.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import todos.list.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
