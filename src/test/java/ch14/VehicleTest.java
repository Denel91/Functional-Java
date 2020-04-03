package ch14;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class VehicleTest {

    @Test
    void TestgetSpeedMph() {
        double timeSec = 10.0;
        int engineHorsePower = 246;
        int vehicleWeightPounds = 4000;

        Engine engine = new Engine();
        engine.setHorsePower(engineHorsePower);

        Vehicle vehicle = new Vehicle(vehicleWeightPounds, engine);
        double speed = vehicle.getSpeedMph(timeSec);

        assertEquals("Assert vehicle (" + engineHorsePower
                + " hp," + vehicleWeightPounds + " lb) speed in "
                + timeSec + " sec: ", 117, speed, 0.001 * speed);
    }

    @Test
    void getSpeedMph() {
        int vehicleWeightPounds = 4000;
        Engine engine = new Engine();

        try {

            Vehicle vehicle = new Vehicle(vehicleWeightPounds, engine);

        } catch (RuntimeException ex) {

            fail("Exception was thrown!");
        }
    }
}