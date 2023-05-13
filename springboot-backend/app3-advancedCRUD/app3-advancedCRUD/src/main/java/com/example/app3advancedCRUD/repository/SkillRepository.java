package com.example.app3advancedCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app3advancedCRUD.models.Skill;


@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	public Skill findByName(String name);
}
