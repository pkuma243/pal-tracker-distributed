package test.pivotal.pal.tracker.projects;

import io.pivotal.pal.tracker.oauthserver.projects.ProjectForm;
import io.pivotal.pal.tracker.oauthserver.projects.ProjectInfo;
import io.pivotal.pal.tracker.oauthserver.projects.data.ProjectFields;
import io.pivotal.pal.tracker.oauthserver.projects.data.ProjectRecord;

import static io.pivotal.pal.tracker.oauthserver.projects.ProjectForm.projectFormBuilder;
import static io.pivotal.pal.tracker.oauthserver.projects.ProjectInfo.projectInfoBuilder;
import static io.pivotal.pal.tracker.oauthserver.projects.data.ProjectFields.projectFieldsBuilder;
import static io.pivotal.pal.tracker.oauthserver.projects.data.ProjectRecord.projectRecordBuilder;

public class TestBuilders {

    public static ProjectRecord.Builder testProjectRecordBuilder() {
        return projectRecordBuilder()
            .id(9L)
            .accountId(23L)
            .name("MyInfo")
            .active(true);
    }

    public static ProjectInfo.Builder testProjectInfoBuilder() {
        return projectInfoBuilder()
            .id(9L)
            .accountId(23L)
            .name("MyInfo")
            .active(true)
            .info("project info");
    }

    public static ProjectFields.Builder testProjectFieldsBuilder() {
        return projectFieldsBuilder()
            .accountId(23L)
            .name("MyInfo")
            .active(true);
    }

    public static ProjectForm.Builder testProjectFormBuilder() {
        return projectFormBuilder()
            .accountId(23L)
            .name("MyInfo")
            .active(true);
    }
}
