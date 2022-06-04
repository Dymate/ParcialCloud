package co.com.poli.projectcloud.projectcloud;

import co.com.poli.projectcloud.projectcloud.persistence.entity.Project;
import co.com.poli.projectcloud.projectcloud.persistence.repository.ProjectRepository;
import co.com.poli.projectcloud.projectcloud.service.ProjectService;
import co.com.poli.projectcloud.projectcloud.service.ProjectServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.hibernate.validator.internal.util.Contracts.assertNotEmpty;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.when;

public class ProjectServiceMockTest {


    @Mock
    private ProjectRepository projectRepository;

    private ProjectService projectService;
    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        project = new Project();

        project.setId(new Long(10));
        project.setProjectName("Proyecto1");
        project.setProjectIdentifier("abc123");
        project.setDescription("prueba");
        project.setStartDate(LocalDate.now());
        project.setEndDate(LocalDate.now().plusDays(2));

        when(projectRepository.findAll()).thenReturn(Arrays.asList(project));

    }

    @Test
    void findAllProjects() {

        Collection<Project> projects = projectRepository.findAll();
        assertNotEmpty(projects, "Prueba ");
    }

}
