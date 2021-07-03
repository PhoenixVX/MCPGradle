package io.github.pheonixvx.mcpgradle.tasks;

import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.nio.file.Path;

public class CleanMCPTask extends AbstractMCPTask {
    private final Path tempPath;
    private final Path patchPath;
    private final Path srcPath;

    public CleanMCPTask() {
        this.tempPath = getProject().file("temp").toPath();
        this.patchPath = getProject().file("patches").toPath();
        this.srcPath = getProject().file("src").toPath();
    }

    @TaskAction
    public void doTask() {
        Project project = getProject();

        File tempFile = tempPath.toFile();
        File patchFile = patchPath.toFile();
        File srcFile = srcPath.toFile();

        project.getLogger().warn(":cleaning MCP workspace");

        if (tempFile.exists()) {
            tempFile.delete();
        }

        if (patchFile.exists()) {
            patchFile.delete();
        }

        if (srcFile.exists()) {
            srcFile.delete();
        }
    }
}
