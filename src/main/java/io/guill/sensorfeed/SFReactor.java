/*
 * This source file is part of the sensor-feeder open source project.
 *
 * Copyright (c) 2018 willy and the sensor-feeder project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package io.guill.sensorfeed;

import lombok.Getter;
import lombok.val;

/**
 * Instance of SFReactor.java
 * 
 * @author 
 * @version 
 */
public class SFReactor {
	
	@Getter private final int numberOfIncidentsToSend;
	private String url;
	
	
	public SFReactor(String url, int numberOfIncidentsToSend) {
		this.numberOfIncidentsToSend = numberOfIncidentsToSend;
		this.url = url;
	}
	
	public void run() {
		for(int i = 0; i < this.numberOfIncidentsToSend; i++) {
			val request = new SFRestQuery();
			request.setUrl( this.url );
			request.send();
		}
	}

}
