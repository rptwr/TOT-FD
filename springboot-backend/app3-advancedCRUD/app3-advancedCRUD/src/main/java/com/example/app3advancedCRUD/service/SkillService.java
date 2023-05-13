package com.example.app3advancedCRUD.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app3advancedCRUD.exception.ResourceNotFoundException;
import com.example.app3advancedCRUD.models.Skill;
import com.example.app3advancedCRUD.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public ResponseEntity<Skill> save(Skill skill) {
		skillRepository.save(skill);
		return ResponseEntity.ok(skill);
	}

	public ResponseEntity<List<Skill>> findAll() {
		List<Skill> skills = skillRepository.findAll();
		return ResponseEntity.ok(skills);
	}

	public ResponseEntity<Skill> findById(Long id) {
		Skill skill = skillRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Skill with " + id + " not found"));
		return ResponseEntity.ok(skill);
	}

	public ResponseEntity<Skill> update(Long id, Skill skillDetails) {
		Skill skill = skillRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Skill with " + id + " not found"));
		skill.setName(skillDetails.getName());
		skill.setEmployees(skillDetails.getEmployees());
		return ResponseEntity.ok(skill);
	}

	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Skill skill = skillRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Skill with " + id + " not found"));
		skillRepository.delete(skill);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
