package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class RulesItem{

	@SerializedName("os")
	private Os os;

	@SerializedName("action")
	private String action;

	public Os getOs(){
		return os;
	}

	public String getAction(){
		return action;
	}
}