/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.cucumberContext;

public class TestContext {
	public ScenarioContext scenarioContext;

	public TestContext() {
		scenarioContext = new ScenarioContext();
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}