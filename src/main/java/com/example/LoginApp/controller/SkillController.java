package com.example.LoginApp.controller;

import com.example.LoginApp.models.Project;
import com.example.LoginApp.models.Skill;
import com.example.LoginApp.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/all")
    public ResponseEntity<List<Skill>> getAllSkills(){
        List<Skill> skillList = skillService.getAllSkills();
        return new ResponseEntity<>(skillList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Skill> findSkillById(@PathVariable("id") Integer id){
        Skill skill = skillService.findSkillById(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill){
        Skill newSkill = skillService.createSkill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill){
        Skill updatedSkill = skillService.updateSkill(skill);
        return new ResponseEntity<>(updatedSkill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable("id") Integer id){
        skillService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}










