package io.github.pheonixvx.mcpgradle.tasks;

import io.github.pheonixvx.mcpgradle.MCPGradleExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.Internal;

public abstract class AbstractMCPTask extends DefaultTask {
    public final Project project = getProject();
    public final Logger logger = project.getLogger();

    public AbstractMCPTask() {
        setGroup("mcpgradle");
    }

    @Internal
    protected MCPGradleExtension getExtension() {
        return getProject().getExtensions().getByType(MCPGradleExtension.class);
    }
}
