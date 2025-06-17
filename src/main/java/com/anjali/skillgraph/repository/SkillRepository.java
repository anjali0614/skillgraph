package com.anjali.skillgraph.repository;

import java.util.List;
import com.anjali.skillgraph.model.Skill;
import com.anjali.skillgraph.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByUser(User user);
}

