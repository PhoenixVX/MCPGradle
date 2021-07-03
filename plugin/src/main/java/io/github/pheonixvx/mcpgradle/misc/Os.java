package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class Os{

	@SerializedName("name")
	private String name;

	@SerializedName("version")
	private String version;

	public String getName(){
		return name;
	}

	public String getVersion(){
		return version;
	}
}