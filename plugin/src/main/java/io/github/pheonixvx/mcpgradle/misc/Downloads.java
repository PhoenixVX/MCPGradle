package io.github.pheonixvx.mcpgradle.misc;

import com.google.gson.annotations.SerializedName;

public class Downloads{

	@SerializedName("classifiers")
	private Classifiers classifiers;

	@SerializedName("artifact")
	private Artifact artifact;

	public Classifiers getClassifiers(){
		return classifiers;
	}

	public Artifact getArtifact(){
		return artifact;
	}
}