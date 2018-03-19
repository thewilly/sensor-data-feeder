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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.Getter;
import lombok.Setter;

/**
 * Instance of SFRestQuery.java
 * 
 * @author
 * @version
 */
public class SFRestQuery {

	@Getter
	@Setter
	private String url;

	/**
	 * 
	 */
	public void send() {

		String incidenceName = new SFRandomize().getName();
		String description = new SFRandomize().getDescription();
		String asignee = new SFRandomize().getAsignee();
		String state = new SFRandomize().getState();
		String tag1 = new SFRandomize().getTag();
		String tag2 = new SFRandomize().getTag();
		String tag3 = new SFRandomize().getTag();
		String tag4 = new SFRandomize().getTag();
		String addinf1 = new SFRandomize().getAddInf();
		String addinf2 = new SFRandomize().getAddInf();
		String addinf3 = new SFRandomize().getAddInf();
		String addinf4 = new SFRandomize().getAddInf();
		String prop1 = new SFRandomize().getProp();
		String prop2 = new SFRandomize().getProp();
		String prop3 = new SFRandomize().getProp();
		String prop4 = new SFRandomize().getProp();
		String val1 = new SFRandomize().getVal();
		String val2 = new SFRandomize().getVal();
		String val3 = new SFRandomize().getVal();
		String val4 = new SFRandomize().getVal();
		
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put( "login", "45170000A" );
		payload.put( "password", "4[[j[frVCUMJ>hU" );
		payload.put( "kind", 1 );
		
		Map<String,Object> messageMap = new HashMap<String, Object>();
		
		messageMap.put( "IncidenceName", incidenceName );
		messageMap.put( "description", description );
		messageMap.put( "asignee", asignee );
		messageMap.put( "expiration", (long)1521475598 );
		messageMap.put( "state", state );
		
		List<String> tags = new ArrayList<String>();
		tags.add( tag1 );
		tags.add( tag2 );
		tags.add( tag3 );
		tags.add( tag4 );
		messageMap.put( "tags", tags );
		
		List<String> additional_information = new ArrayList<String>();
		additional_information.add( addinf1 );
		additional_information.add( addinf2 );
		additional_information.add( addinf3 );
		additional_information.add( addinf4 );
		messageMap.put( "additional_information", additional_information );
		
		Map<String,String> properties = new HashMap<String, String>();
		properties.put( prop1, val1 );
		properties.put( prop2, val2 );
		properties.put( prop3, val3 );
		properties.put( prop4, val4 );
		messageMap.put( "properties", properties );
		
		payload.put( "message", messageMap );
		
		//System.out.println( new JSONObject( payload ).toString() );
		
		try {
			Unirest.post( url ).header( "Content-Type", "application/json" )
					.body( new JsonNode( new JSONObject( payload ).toString() ) ).asString();

			System.out.println( "COMPLETED: " + new JSONObject( payload ).toString());
		} catch (UnirestException e) {
			System.out.println( "FAILING AT QUERING: " + url);
			System.out.println( "FOR QUERY: " + new JSONObject( payload ).toString());
			e.printStackTrace();
		}
	}

}
