package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}

