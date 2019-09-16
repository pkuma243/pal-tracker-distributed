package io.pivotal.pal.tracker.oauthserver.projects;

import io.pivotal.pal.tracker.oauthserver.projects.data.ProjectDataGateway;
import io.pivotal.pal.tracker.oauthserver.projects.data.ProjectFields;
import io.pivotal.pal.tracker.oauthserver.projects.data.ProjectRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.pivotal.pal.tracker.oauthserver.projects.ProjectInfo.projectInfoBuilder;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectDataGateway gateway;

    public ProjectController(ProjectDataGateway gateway) {
        this.gateway = gateway;
    }

    @PostMapping
    public ResponseEntity<ProjectInfo> create(@RequestBody ProjectForm form) {
        ProjectRecord record = gateway.create(formToFields(form));
        return new ResponseEntity<>(present(record), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProjectInfo> list(@RequestParam long accountId) {
        return gateway.findAllByAccountId(accountId)
            .stream()
            .map(this::present)
            .collect(toList());
    }

    @GetMapping("/{projectId}")
    public ProjectInfo get(@PathVariable long projectId) {
        ProjectRecord record = gateway.find(projectId);

        if (record != null) {
            return present(record);
        }

        return null;
    }


    private ProjectFields formToFields(ProjectForm form) {
        return ProjectFields.projectFieldsBuilder()
            .accountId(form.accountId)
            .name(form.name)
            .active(form.active)
            .build();
    }

    private ProjectInfo present(ProjectRecord record) {
        return projectInfoBuilder()
            .id(record.id)
            .accountId(record.accountId)
            .name(record.name)
            .active(record.active)
            .info("project info")
            .build();
    }
}
