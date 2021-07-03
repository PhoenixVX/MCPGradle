package io.github.pheonixvx.mcpgradle;

import org.gradle.api.Project;

import java.io.File;

public class MCPGradleExtension {
    // Settable properties

    /**
     * This determines whether Minecraft is to be remapped or not.
     * If this is false, Minecraft will be decompiled in obfuscated mappings.
     *
     * Note: Patches will not be developed for these, although you can create your own.
     */
    public boolean remapMinecraft = true;

    /**
     * This determines what version of Minecraft MCPGradle will download.
     * This must be set, or else MCPGradle will error.
     */
    public String minecraft = null;

    /**
     * This determines what MCPGradle will download as for mappings.
     * This also must be set, or else MCPGradle will error.
     */
    public String mappings = null;

    /**
     * This determines what patches MCPGradle will download and use to patch the decompiled code.
     */
    public String patches = null;

    // Unsettable properties

    /**
     * References the current project.
     */
    private final Project project;

    /**
     * This determines what decompiler MCPGradle will use.
     * Fernflower is the only official supported decompiler, as of this time.
     */
    private final String decompiler = "fernflower";

    public MCPGradleExtension(Project project) {
        this.project = project;
    }

    /**
     * @return {@link File} A file containing the root project temporary cache
     */
    public File getRootProjectTempCache() {
        File projectCache = new File(project.getRootProject().file(".gradle"), "temp");

        if (!projectCache.exists()) {
            projectCache.mkdirs();
        }

        return projectCache;
    }

    /**
     * @return {@link File} A file containing the root project's native folder.
     */
    public File getNativesFolder() {
        File nativesFolder = project.getRootProject().file("natives");

        if (!nativesFolder.exists()) {
            nativesFolder.mkdirs();
        }

        return nativesFolder;
    }

    public void minecraft(String minecraftVersionJSON) {
        this.minecraft = minecraftVersionJSON;
    }

    public void mappings(String mappingsUrl) {
        this.mappings = mappingsUrl;
    }

    public void patches(String patchesUrl) {
        this.patches = patchesUrl;
    }
}
