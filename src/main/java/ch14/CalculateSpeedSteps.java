package ch14;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class CalculateSpeedSteps {
    private Vehicle vehicle;
    private double speed;

    @Given("the vehicle has {int} hp engine and weighs {int} pounds")
    public void the_vehicle_hp_engine_and_weighs_pounds(Integer wp, Integer hp) {
        vehicle = new Vehicle(wp, hp);
    }

    @When("the application calculates its speed after {double} sec")
    public void the_application_calculates_its_speed_after_sec(double timeSec) {
        speed = vehicle.getSpeedMph(timeSec);
    }

    @Then("the result should be {double} mph")
    public void the_result_should_be_mph(double speed) {
        assertEquals(speed, this.speed, 0.0001 * speed);
    }

    class Vehicle {
        private int wp, hp;

        public Vehicle(int hp, int weightPounds) {
            this.hp = hp;
            this.wp = weightPounds;
        }

        public double getSpeedMph(double timeSec) {
            double v = 2.0 * this.hp * 746 * timeSec * 32.17 / this.wp;
            return Math.round(Math.sqrt(v) * 0.68);
        }
    }
}


