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

/**
 * Instance of SFStartup.java
 * 
 * @author 
 * @version 
 */
public class SFStartup {

	public static void main(String... args) {
		new SFReactor(args[0], Integer.parseInt( args[1] )).run();
	}
	
}
