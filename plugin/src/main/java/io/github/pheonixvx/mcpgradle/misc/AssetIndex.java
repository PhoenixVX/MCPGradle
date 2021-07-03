package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class AssetIndex{

	@SerializedName("sha1")
	private String sha1;

	@SerializedName("totalSize")
	private int totalSize;

	@SerializedName("size")
	private int size;

	@SerializedName("id")
	private String id;

	@SerializedName("url")
	private String url;

	public String getSha1(){
		return sha1;
	}

	public int getTotalSize(){
		return totalSize;
	}

	public int getSize(){
		return size;
	}

	public String getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}
}