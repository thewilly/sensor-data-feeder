package io.guill.sensorfeed.types;

import java.util.concurrent.ThreadLocalRandom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sensor {
    private String sensorId;
    private String unitsOfMeasure;
    private String coordinates; //43°34'38.7"N 5°57'36.8"W
    private double lowerMeasureRange, upperMeasureRange;

    public double meassure() {
	return ThreadLocalRandom.current().nextDouble(lowerMeasureRange, upperMeasureRange + 1);
    }
}
