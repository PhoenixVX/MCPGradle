package io.github.pheonixvx.mcpgradle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.PluginAware;
import com.google.common.collect.ImmutableMap;

public class MCPGradlePlugin implements Plugin<PluginAware> {

    public static final Logger LOGGER = LogManager.getLogger("MCPGradle");
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void apply(PluginAware target) {
        if (target instanceof Project) {
            applyProject((Project) target);
        } else {
            LOGGER.error("MCPGradle was expecting a project, quiting...");
        }
    }

    private void applyProject(Project project) {
        // Setup default plugins. All MCPGradle projects will require Java.
        // Eclipse and Idea are for generating run configs
        project.apply(ImmutableMap.of("plugin", "java"));
        project.apply(ImmutableMap.of("plugin", "eclipse"));
        project.apply(ImmutableMap.of("plugin", "idea"));

        // Setup extensions
        project.getExtensions().create("mcpgradle", MCPGradleExtension.class, project);

        // Setup configuration
        MCPGradleTasks.registerTasks(project);
    }
}
