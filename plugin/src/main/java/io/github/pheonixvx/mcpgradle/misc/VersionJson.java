package io.github.pheonixvx.mcpgradle.misc;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VersionJson{

	@SerializedName("assets")
	private String assets;

	@SerializedName("minecraftArguments")
	private String minecraftArguments;

	@SerializedName("releaseTime")
	private String releaseTime;

	@SerializedName("mainClass")
	private String mainClass;

	@SerializedName("downloads")
	private Downloads downloads;

	@SerializedName("libraries")
	private List<LibrariesItem> libraries;

	@SerializedName("minimumLauncherVersion")
	private int minimumLauncherVersion;

	@SerializedName("assetIndex")
	private AssetIndex assetIndex;

	@SerializedName("id")
	private String id;

	@SerializedName("time")
	private String time;

	@SerializedName("type")
	private String type;

	public String getAssets(){
		return assets;
	}

	public String getMinecraftArguments(){
		return minecraftArguments;
	}

	public String getReleaseTime(){
		return releaseTime;
	}

	public String getMainClass(){
		return mainClass;
	}

	public Downloads getDownloads(){
		return downloads;
	}

	public List<LibrariesItem> getLibraries(){
		return libraries;
	}

	public int getMinimumLauncherVersion(){
		return minimumLauncherVersion;
	}

	public AssetIndex getAssetIndex(){
		return assetIndex;
	}

	public String getId(){
		return id;
	}

	public String getTime(){
		return time;
	}

	public String getType(){
		return type;
	}
}