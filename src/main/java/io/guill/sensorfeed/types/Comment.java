package io.guill.sensorfeed.types;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
	private Date date = new Date();
	private String operatorId = "";
	private String comment = "";
}
