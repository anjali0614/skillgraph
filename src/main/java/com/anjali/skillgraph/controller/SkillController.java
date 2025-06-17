package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.dto.SkillDTO;
import com.anjali.skillgraph.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.ok("Skill deleted successfully");
    }
    @PutMapping("/update/{skillId}")
    public ResponseEntity<SkillDTO> updateSkill(@PathVariable Long skillId, @RequestBody SkillDTO skillDTO) {
        SkillDTO updatedSkill = skillService.updateSkill(skillId, skillDTO);
        return ResponseEntity.ok(updatedSkill);
    }

}

