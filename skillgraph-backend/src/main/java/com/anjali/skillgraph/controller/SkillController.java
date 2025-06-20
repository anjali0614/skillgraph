package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.dto.SkillDTO;
import com.anjali.skillgraph.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<SkillDTO> createSkill(@PathVariable Long userId, @RequestBody SkillDTO skillDTO) {
        SkillDTO created = skillService.createSkill(userId, skillDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillDTO>> getSkillsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillService.getSkillsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getSkillById(id));
    }

    @GetMapping("/{userId}/skills/{skillId}")
    public ResponseEntity<SkillDTO> getSkillByUserIdAndSkillId(
            @PathVariable Long userId,
            @PathVariable Long skillId) {
        SkillDTO skillDTO = skillService.getSkillByUserIdAndSkillId(userId, skillId);
        return ResponseEntity.ok(skillDTO);
    }

    @GetMapping("/{userId}/skills/search")
    public ResponseEntity<List<SkillDTO>> searchSkillsByName(
            @PathVariable Long userId,
            @RequestParam String keyword) {
        List<SkillDTO> skills = skillService.searchSkillsByName(userId, keyword);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{userId}/skills/sorted")
    public ResponseEntity<List<SkillDTO>> getSortedSkills(
            @PathVariable("userId") Long userId,
            @RequestParam(name = "order", defaultValue = "asc") String order) {
        List<SkillDTO> skills = skillService.getSkillsSortedByProficiency(userId, order);
        return ResponseEntity.ok(skills);
    }


    @DeleteMapping("/{userId}/skills/{skillId}")
    public ResponseEntity<String> deleteSkill(
            @PathVariable Long userId,
            @PathVariable Long skillId) {
        skillService.deleteSkill(userId, skillId);
        return ResponseEntity.ok("Skill deleted successfully.");
    }

    @PutMapping("/{userId}/skills/{skillId}")
    public ResponseEntity<SkillDTO> updateSkill(
            @PathVariable Long userId,
            @PathVariable Long skillId,
            @RequestBody SkillDTO skillDTO) {
        SkillDTO updatedSkill = skillService.updateSkill(userId, skillId, skillDTO);
        return ResponseEntity.ok(updatedSkill);
    }

}

