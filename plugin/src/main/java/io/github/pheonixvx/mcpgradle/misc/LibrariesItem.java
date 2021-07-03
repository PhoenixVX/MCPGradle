package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LibrariesItem{

	@SerializedName("extract")
	private Extract extract;

	@SerializedName("downloads")
	private Downloads downloads;

	@SerializedName("name")
	private String name;

	@SerializedName("natives")
	private Natives natives;

	@SerializedName("rules")
	private List<RulesItem> rules;

	public Extract getExtract(){
		return extract;
	}

	public Downloads getDownloads(){
		return downloads;
	}

	public String getName(){
		return name;
	}

	public Natives getNatives(){
		return natives;
	}

	public List<RulesItem> getRules(){
		return rules;
	}
}