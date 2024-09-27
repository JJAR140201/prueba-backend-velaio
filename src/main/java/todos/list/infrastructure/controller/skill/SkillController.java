package todos.list.infrastructure.controller.skill;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todos.list.application.service.skill.SkillService;
import todos.list.infrastructure.dto.SkillDTO;

import java.util.List;

@RestController
@RequestMapping("/skills")
@CrossOrigin("*")
@RequiredArgsConstructor
@Tag(name = "Skill Management", description = "Operaciones relacionadas con la gestión de habilidades")
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    @Operation(summary = "Obtener todas las habilidades", description = "Devuelve una lista de todas las habilidades registradas")
    public List<SkillDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una habilidad por ID", description = "Devuelve una habilidad según el ID proporcionado")
    public SkillDTO getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva habilidad", description = "Crea una nueva habilidad con los datos proporcionados")
    public SkillDTO createSkill(@RequestBody SkillDTO skillDTO) {
        return skillService.createSkill(skillDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una habilidad", description = "Actualiza una habilidad existente según el ID proporcionado")
    public SkillDTO updateSkill(@PathVariable Long id, @RequestBody SkillDTO skillDTO) {
        return skillService.updateSkill(id, skillDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una habilidad por ID", description = "Elimina una habilidad según el ID proporcionado")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }

}
