package io.github.pheonixvx.mcpgradle;

import io.github.pheonixvx.mcpgradle.tasks.CleanMCPTask;
import io.github.pheonixvx.mcpgradle.tasks.DownloadMCPTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

public class MCPGradleTasks {

    public static void registerTasks(Project project) {
        TaskContainer tasks = project.getTasks();

        tasks.register("cleanMCP", CleanMCPTask.class, description -> description.setDescription("Cleans the MCP workspace. NOTE: This is irreversible."));
        tasks.register("downloadMCP", DownloadMCPTask.class, description -> description.setDescription("Downloads the necessary MCP components"));
    }
}
