package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class Natives{

	@SerializedName("osx")
	private String osx;

	@SerializedName("linux")
	private String linux;

	@SerializedName("windows")
	private String windows;

	public String getOsx(){
		return osx;
	}

	public String getLinux(){
		return linux;
	}

	public String getWindows(){
		return windows;
	}
}