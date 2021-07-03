package io.github.pheonixvx.mcpgradle.tasks;

import io.github.pheonixvx.mcpgradle.MCPGradleExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Internal;

public abstract class AbstractMCPTask extends DefaultTask {
    public AbstractMCPTask() {
        setGroup("io/github/pheonixvx/mcpgradle");
    }

    @Internal
    protected MCPGradleExtension getExtension() {
        return getProject().getExtensions().getByType(MCPGradleExtension.class);
    }
}
