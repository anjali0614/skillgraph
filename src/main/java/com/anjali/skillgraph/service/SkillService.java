package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.SkillDTO;
import com.anjali.skillgraph.model.Skill;
import com.anjali.skillgraph.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = new Skill(
                skillDTO.getName(),
                skillDTO.getDescription(),
                skillDTO.getProficiency()
        );
        Skill saved = skillRepository.save(skill);

        return new SkillDTO(saved.getId(), saved.getName(), saved.getDescription(), saved.getProficiency());
    }

    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(skill -> new SkillDTO(skill.getId(), skill.getName(), skill.getDescription(), skill.getProficiency()))
                .collect(Collectors.toList());
    }

    public SkillDTO getSkillById(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        return new SkillDTO(skill.getId(), skill.getName(), skill.getDescription(), skill.getProficiency());
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}

