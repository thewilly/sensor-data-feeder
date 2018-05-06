package io.guill.sensorfeed.tasks;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.guill.sensorfeed.types.Comment;
import io.guill.sensorfeed.types.Incident;
import io.guill.sensorfeed.types.Sensor;

public class AbstractSensorTask extends TimerTask {

	private Sensor sensor;
	public int msBetweenReads;
	private Incident incident;
	private String endpoint;

	public AbstractSensorTask( String endpoint, Sensor sensor, int secondsBetweenReads ) {
		this.endpoint = endpoint;
		this.sensor = sensor;
		this.msBetweenReads = secondsBetweenReads;
	}

	@Override
	public void run() {
		System.out.println( "Generating incident lecture and sending it to: " + endpoint );
		incident = new Incident();
		incident.setAgentId( sensor.getSensorId() );
		incident.setTitle( "Measure " + new Date().toString() );
		incident.setDescription( "Measure in " + sensor.getUnitsOfMeasure() );
		incident.setStatus( "IN_PROCESS" );
		incident.setOperatorId( "" );
		incident.setLocation( sensor.getLocation() );
		Map<String, String> properties = new HashMap<String, String>();
		properties.put( sensor.getUnitsOfMeasure(), Double.toString( sensor.meassure() ) );
		incident.setPropertyVal( properties );
		incident.setComments( new Comment[0] );

		try {
			String obsAsString = new ObjectMapper().writeValueAsString( incident );
			JsonNode json = new JsonNode( obsAsString );
			json.getObject().put( "login", this.sensor.getLogin() );
			json.getObject().put( "password", this.sensor.getPassword() );
			json.getObject().put( "kind", 3 );

			System.out.println( json );
			System.out.println( Unirest.post( endpoint )
					.header( "Content-Type", "application/json; charset=utf8;" )
					.body( json ).asJson().getBody() );

		} catch (JsonProcessingException | UnirestException | JSONException e) {
			e.printStackTrace();
		}
	}
}
