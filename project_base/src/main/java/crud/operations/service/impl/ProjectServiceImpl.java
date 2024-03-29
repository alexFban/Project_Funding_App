package crud.operations.service.impl;

import crud.operations.repository.ProjectRepository;
import crud.operations.service.ProjectService;
import lombok.AllArgsConstructor;
import crud.operations.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A class that implements {@link ProjectService} interface methods.
 */
@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    /**
     * Instance of {@link ProjectRepository} class
     */
    private ProjectRepository projectRepository;
    /**
     * Adds new Project to the DataBase. Equivalent to the POST operation.
     * @param project The user data we want to be saved.
     * @return The new repository, with the saved Project.
     */
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
    /**
     * Searches for a Project with the given id. Equivalent to the GET operation.
     * @param projectId The project id we want to be searched.
     * @return The Project with the searched id (if it exists).
     */
    @Override
    public Project getProjectById(Long projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        return optionalProject.get();
    }
    /**
     * Gets all projects that are currently found in the DataBase. Equivalent to the GET operation without any parameters.
     * @return All Projects.
     */
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    /**
     * Adds/modifies data of an existing Project. Equivalent to the PUT operation.
     * @param project The project data we want to be modified.
     * @return The modified project data.
     */
    @Override
    public Project updateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getId()).get();
        existingProject.setFunding_goal(project.getFunding_goal());
        existingProject.setMoney_raised(project.getMoney_raised());
        existingProject.setDescription(existingProject.getDescription());
        Project updatedProject = projectRepository.save(existingProject);
        return updatedProject;
    }
    /**
     * Deletes Project with the given id. Equivalent to the DELETE operation.
     * @param projectId The project id we want to be searched.
     */
    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
