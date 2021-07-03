package io.github.pheonixvx.mcpgradle.tasks;

import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.nio.file.Path;

public class CleanMCPTask extends AbstractMCPTask {
    private final Path tempPath;
    private final Path patchPath;
    private final Path srcPath;

    public CleanMCPTask() {
        this.tempPath = this.project.file("temp").toPath();
        this.patchPath = this.project.file("patches").toPath();
        this.srcPath = this.project.file("src").toPath();
    }

    @TaskAction
    public void doTask() {
        File tempFile = tempPath.toFile();
        File patchFile = patchPath.toFile();
        File srcFile = srcPath.toFile();

        this.logger.warn(": cleaning MCP workspace");

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
