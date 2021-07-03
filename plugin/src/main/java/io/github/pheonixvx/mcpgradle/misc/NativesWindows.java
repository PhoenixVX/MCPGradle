package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class NativesWindows{

	@SerializedName("sha1")
	private String sha1;

	@SerializedName("path")
	private String path;

	@SerializedName("size")
	private int size;

	@SerializedName("url")
	private String url;

	public String getSha1(){
		return sha1;
	}

	public String getPath(){
		return path;
	}

	public int getSize(){
		return size;
	}

	public String getUrl(){
		return url;
	}
}