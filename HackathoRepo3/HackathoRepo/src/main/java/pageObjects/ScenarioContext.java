package pageObjects;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> data;

    public ScenarioContext() {
        data = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        data.put(key, value);
    }

    public Object getContext(String key) {
        return data.get(key);
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }

}
