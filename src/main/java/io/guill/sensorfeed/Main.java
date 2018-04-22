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

import java.util.Date;
import java.util.Timer;

import io.guill.sensorfeed.tasks.AbstractSensorTask;
import io.guill.sensorfeed.types.Sensor;

/**
 * Instance of SFStartup.java
 * 
 * @author
 * @version
 */
public class Main {

    public static void main(String... args) {
	Timer timer = new Timer();
	
	AbstractSensorTask task1 = new AbstractSensorTask(
		args[0],
		
		Sensor.builder()
		.sensorId("5ad12d5d71b7a726c78124c5")
		.unitsOfMeasure("temperature")
		.lowerMeasureRange(-10.0)
		.upperMeasureRange(30.0)
		.build()
		
		, 10000);
	
	timer.schedule(task1, new Date(), task1.msBetweenReads);
    }

}
