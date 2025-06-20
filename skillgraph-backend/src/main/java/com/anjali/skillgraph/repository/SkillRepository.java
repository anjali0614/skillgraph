package com.anjali.skillgraph.repository;

import java.util.List;
import java.util.Optional;
import com.anjali.skillgraph.model.Skill;
import com.anjali.skillgraph.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByUser(User user);
    Optional<Skill> findByIdAndUserId(Long skillId, Long userId);
    List<Skill> findByUserIdAndNameContainingIgnoreCase(Long userId, String name);

    List<Skill> findByUserIdOrderByProficiencyAsc(Long userId);
    List<Skill> findByUserIdOrderByProficiencyDesc(Long userId);

}

