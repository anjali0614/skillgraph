package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.SkillDTO;

import java.util.List;

public interface SkillService {
    SkillDTO createSkill(Long userId, SkillDTO skillDTO);
    List<SkillDTO> getSkillsByUser(Long userId);
    SkillDTO getSkillById(Long id);
    List<SkillDTO> searchSkillsByName(Long userId, String keyword);
    List<SkillDTO> getSkillsSortedByProficiency(Long userId, String order);
    void deleteSkill(Long userId, Long skillId);
    SkillDTO updateSkill(Long userId, Long skillId, SkillDTO skillDTO);
    SkillDTO getSkillByUserIdAndSkillId(Long userId, Long skillId);

}


