package io.guill.sensorfeed.types;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Incident {
	private String incidentId = "";
	private String title = "";
	private String description = "";
	private String status = "";
	private String location = "";
	private String[] tags = { "" };
	private String[] multimedia = { "" };
	@JsonProperty("prop-val")
	private Map<String, String> propertyVal = new HashMap<String, String>();
	private Comment[] comments;
	private String agentId = "";
	private String operatorId = "";
}
