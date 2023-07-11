package com.example.LoginApp.service;

import com.example.LoginApp.exception.ProjectNotFoundException;
import com.example.LoginApp.exception.SkillNotFoundException;
import com.example.LoginApp.models.Project;
import com.example.LoginApp.models.Skill;
import com.example.LoginApp.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill findSkillById(Integer id) {
        return skillRepository.findSkillById(id).orElseThrow(() ->
                new ProjectNotFoundException("Project by Id: " + id + " was not found"));
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Skill skill) {
        Optional<Skill> existingSkill = skillRepository.findById(skill.getId());
        if (existingSkill.isPresent()) {
            Skill updatedSkill = existingSkill.get();
            updatedSkill.setName(skill.getName());
            updatedSkill.setGrade(skill.getGrade());
            updatedSkill.setProfiles(skill.getProfiles());

            return skillRepository.save(updatedSkill);
        } else {
            throw new SkillNotFoundException("Skill by Id " + skill.getId() + " was not found");
        }
    }


    public void deleteById(Integer id) {
        skillRepository.deleteSkillById(id);
    }
}
