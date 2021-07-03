package io.github.pheonixvx.mcpgradle.misc;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Extract{

	@SerializedName("exclude")
	private List<String> exclude;

	public List<String> getExclude(){
		return exclude;
	}
}