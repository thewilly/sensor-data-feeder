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

import java.util.Random;

/**
 * Instance of SFRandomize.java
 * 
 * @author 
 * @version 
 */
public class SFRandomize {
	
	private static String[] names = {"Incendio","Lectura Temperatura","Radiación","Emergencia"};
	private static String[] status = {"abierta","en proceso","cerrada"};
	private static String[] descriptions = {"Incendio forestal en lorem ipsum",
			"Grandes inundaciones sacuden meeeexicoo",
			"Trafico lento en AS-7",
			"Nevadas graves a la altura de pajares",
			"Explosión nuclear en central electrica de miCasaTodoJuntoSI"};
	private static String[] asignees = {"1","2","3","4"};
	private static String[] tags = {"Radiación","Lluvia","Viento","Temperatura","Fuego","Peligro","Nieve"};
	private static String[] addinfs = {"imagen1","imagen2","imagen4","imagen3","comentario muy largo", "link1", "video en directo"};
	private static String[] props = {"temperatura", "lluvia", "velocidad del viento", "indice de radiación", "presión", "altura"};
	private static String[] vals = {"1","11","123","643","-1345","222","873"};
	
	private Random random;
	
	public String getName() {
		random = new Random();
		return names[random.nextInt( names.length )];
	}
	
	public String getState() {
		random = new Random();
		return status[random.nextInt( status.length )];
	}
	
	public String getDescription() {
		random = new Random();
		return descriptions[random.nextInt( descriptions.length )];
	}
	
	public String getAsignee() {
		random = new Random();
		return asignees[random.nextInt( asignees.length )];
	}
	
	public String getTag() {
		random = new Random();
		return tags[random.nextInt( tags.length )];
	}
	
	public String getAddInf() {
		random = new Random();
		return addinfs[random.nextInt( addinfs.length )];
	}
	
	public String getProp() {
		random = new Random();
		return props[random.nextInt( props.length )];
	}
	
	public String getVal() {
		random = new Random();
		return vals[random.nextInt( vals.length )];
	}
	

}
