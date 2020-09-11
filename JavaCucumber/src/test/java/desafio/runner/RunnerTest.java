package desafio.runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
				features = {"src/test/resources/features"}, 
				glue = {"desafio.steps", "desafio.setup"})

public class RunnerTest {

}
