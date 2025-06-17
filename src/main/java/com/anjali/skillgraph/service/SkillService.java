package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.SkillDTO;

import com.anjali.skillgraph.dto.SkillDTO;
import java.util.List;

public interface SkillService {
    SkillDTO createSkill(Long userId, SkillDTO skillDTO);
    List<SkillDTO> getSkillsByUser(Long userId);
    SkillDTO getSkillById(Long id);
    void deleteSkill(Long id);
    SkillDTO updateSkill(Long skillId, SkillDTO skillDTO);
}


