package todos.list.infrastructure.mapper;

import todos.list.domain.Skill;
import todos.list.infrastructure.dto.SkillDTO;

public class SkillMapper {

    public static SkillDTO toDto(Skill skill) {
        return new SkillDTO(
                skill.getId(),
                skill.getName(),
                skill.getUser().getId()  // Asumiendo que Skill tiene relación con User
        );
    }

    public static Skill toEntity(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setId(skillDTO.getId());
        skill.setName(skillDTO.getName());
        // La relación con el usuario se maneja en el servicio
        return skill;
    }

}
