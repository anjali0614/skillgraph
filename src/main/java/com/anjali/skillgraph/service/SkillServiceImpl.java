package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.SkillDTO;
import com.anjali.skillgraph.exception.ResourceNotFoundException;
import com.anjali.skillgraph.model.Skill;
import com.anjali.skillgraph.model.User;
import com.anjali.skillgraph.repository.SkillRepository;
import com.anjali.skillgraph.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public SkillDTO createSkill(Long userId, SkillDTO skillDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Skill skill = new Skill();
        skill.setName(skillDTO.getName());
        skill.setDescription(skillDTO.getDescription());
        skill.setProficiency(skillDTO.getProficiency());
        skill.setUser(user); // Link skill to user

        Skill saved = skillRepository.save(skill);
        return mapToDTO(saved);
    }

    @Override
    public List<SkillDTO> getSkillsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<Skill> skills = skillRepository.findByUser(user);

        return skills.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SkillDTO getSkillById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));

        return mapToDTO(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public SkillDTO updateSkill(Long skillId, SkillDTO skillDTO) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + skillId));

        skill.setName(skillDTO.getName());
        skill.setDescription(skillDTO.getDescription());
        skill.setProficiency(skillDTO.getProficiency());

        Skill updated = skillRepository.save(skill);
        return mapToDTO(updated);
    }

    private SkillDTO mapToDTO(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setDescription(skill.getDescription());
        dto.setProficiency(skill.getProficiency());
        return dto;
    }
}


