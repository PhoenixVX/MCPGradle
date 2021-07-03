package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class Classifiers{

	@SerializedName("natives-windows")
	private NativesWindows nativesWindows;

	@SerializedName("natives-osx")
	private NativesOsx nativesOsx;

	@SerializedName("natives-linux")
	private NativesLinux nativesLinux;

	public NativesWindows getNativesWindows(){
		return nativesWindows;
	}

	public NativesOsx getNativesOsx(){
		return nativesOsx;
	}

	public NativesLinux getNativesLinux(){
		return nativesLinux;
	}
}