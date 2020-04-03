package ch14;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Main class to run scenarious test
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, strict = true, features = {"classpath:features/CalculateSpeed.feature"})
public class RunScenariousTest {
}

