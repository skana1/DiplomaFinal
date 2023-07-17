package com.example.LoginApp.service;

import com.example.LoginApp.authenticate.ProjectCreateRequest;
import com.example.LoginApp.exception.ProjectNotFoundException;
import com.example.LoginApp.models.Company;
import com.example.LoginApp.models.Project;
import com.example.LoginApp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final CompanyService companyService;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project findProjectById(Integer id) {
        return projectRepository.findProjectById(id).orElseThrow(() ->
                new ProjectNotFoundException("Project by Id: " + id + " was not found"));
    }

    public Project createProject(ProjectCreateRequest project) {
        Company company = companyService.findCompanyById(project.getCompany_id());

        Project buildProject = Project.builder()
                .name(project.getName())
                .duration(project.getDuration())
                .source(project.getSource())
                .company(company)
                .build();
        return projectRepository.save(buildProject);
    }

    public Project updateProject(Project project) {
        Optional<Project> existingProject = projectRepository.findById(project.getId());
        if (existingProject.isPresent()) {
            Project updatedProject = existingProject.get();
            updatedProject.setTasks(project.getTasks());
            updatedProject.setCompany(project.getCompany());
            updatedProject.setName(project.getName());
            updatedProject.setDuration(project.getDuration());
            updatedProject.setSource(project.getSource());

            return projectRepository.save(updatedProject);
        } else {
            throw new ProjectNotFoundException("Project by Id " + project.getId() + " was not found");
        }
    }


    @Transactional
    public void deleteById(Integer id) {
        projectRepository.deleteProjectById(id);
    }

}
