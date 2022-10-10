/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package framework.cucumberContext;

import java.util.HashMap;
import java.util.Map;

import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.enums.ServiceRequestContext;

public class ScenarioContext {

	private Map<String, Object> scenarioContext;

	public ScenarioContext() {
		scenarioContext = new HashMap<>();
	}

	public void setContext(GenericContext key, Object value) {
		scenarioContext.put(key.toString(), value);
	}

	public void setContext(RegistrationContext key, Object value) {
		scenarioContext.put(key.toString(), value);
	}

	public void setContext(ServiceRequestContext key, Object value) {
		scenarioContext.put(key.toString(), value);
	}

	public Object getContext(GenericContext key) {
		return scenarioContext.get(key.toString());
	}

	public Object getContext(RegistrationContext key) {
		return scenarioContext.get(key.toString());
	}

	public Object getContext(ServiceRequestContext key) {
		return scenarioContext.get(key.toString());
	}

	public Boolean contains(GenericContext key) {
		return scenarioContext.containsKey(key.toString());
	}

	public Boolean contains(ServiceRequestContext key) {
		return scenarioContext.containsKey(key.toString());
	}

	public Boolean contains(RegistrationContext key) {
		return scenarioContext.containsKey(key.toString());
	}
}