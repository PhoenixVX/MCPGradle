package io.github.pheonixvx.mcpgradle.tasks;

import io.github.pheonixvx.mcpgradle.MCPGradleExtension;
import io.github.pheonixvx.mcpgradle.MCPGradlePlugin;
import io.github.pheonixvx.mcpgradle.misc.Downloads;
import io.github.pheonixvx.mcpgradle.misc.LibrariesItem;
import io.github.pheonixvx.mcpgradle.misc.VersionJson;
import net.lingala.zip4j.ZipFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DownloadMCPTask extends AbstractMCPTask {

    private final String minecraftUrl;
    private final String mappingsUrl;
    private final String patchesUrl;

    private final boolean remapMinecraft;

    public DownloadMCPTask() {
        this.minecraftUrl = this.project.getExtensions().findByType(MCPGradleExtension.class).minecraft;
        this.mappingsUrl = this.project.getExtensions().findByType(MCPGradleExtension.class).mappings;
        this.patchesUrl = this.project.getExtensions().findByType(MCPGradleExtension.class).patches;
        this.remapMinecraft = this.project.getExtensions().findByType(MCPGradleExtension.class).remapMinecraft;
    }

    private static void downloadFromUrl(String sourceURL, File targetFile) {
        try {
            URL url = new URL(sourceURL);
            Path targetPath = targetFile.toPath();
            Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @TaskAction
    public void doTask() {
        File tempMCGradle = new File(this.project.file("temp"), "mcpgradle");
        if (!tempMCGradle.exists()) {
            tempMCGradle.mkdirs();
        }

        if (this.minecraftUrl != null) {
            this.logger.info(": downloading minecraft version JSON from " + this.minecraftUrl);
            File file = new File(tempMCGradle, "version.json");
            downloadFromUrl(this.minecraftUrl, file);

            // TODO: Download MC and libraries
            try {
                String string = String.valueOf(Files.readAllLines(file.toPath()));
                System.out.println(string);
                VersionJson version = MCPGradlePlugin.gson.fromJson(String.valueOf(Files.readAllLines(file.toPath())), VersionJson.class);

                String mcUrl = version.getDownloads().getArtifact().getUrl();
                downloadFromUrl(mcUrl, new File(tempMCGradle, "minecraft.jar"));

                File libraries = this.project.file("libs");
                if (!libraries.exists()) {
                    libraries.mkdirs();
                }

                for (LibrariesItem item : version.getLibraries()) {
                    String url = item.getDownloads().getArtifact().getUrl();
                    downloadFromUrl(url, new File(libraries, url.substring(-1, '.')));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new AssertionError("Minecraft is not supposed to be null!!!");
        }

        if (this.mappingsUrl != null && this.remapMinecraft) {
            this.logger.info(": downloading mappings from URL: " + this.mappingsUrl);
            downloadFromUrl(this.mappingsUrl, new File(tempMCGradle, "mappings.tiny"));
        } else if (!this.remapMinecraft) {
            this.logger.info(": not remapping Minecraft because property remapMinecraft is false");
        } else {
            throw new AssertionError("Mappings are not supposed to be null!!! Use property remapMinecraft instead");
        }

        if (this.patchesUrl != null) {
            // Patches are expected to be a JAR file
            this.logger.info(": downloading patches from URL: " + this.patchesUrl);
            File file = new File(tempMCGradle, "patches.jar");
            downloadFromUrl(this.patchesUrl, file);

            try {
                ZipFile zipFile = new ZipFile(file);
                zipFile.extractAll(tempMCGradle.toPath().toAbsolutePath().toString());

                file.delete();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
