package properties;

import java.util.HashMap;
import java.util.Map;

public class Properties {
	private Map<String, String> map;
	private Properties defaults;
	
	public Properties() {
		map = new HashMap<String, String>();
	}
	
	public Properties(Properties defaults) {
		map = new HashMap<String, String>();
		this.defaults = defaults;
	}
	
	public void setProperty(String name, String value) {
		map.put(name, value);
	}
	
	public void setDefault(Properties defaults) {
		this.defaults = defaults;
	}
	
	public String getPropertyValue(String name) {
		String val = map.get(name);
		if(val == null) {
			if(defaults != null) {
				val = defaults.getPropertyValue(name);
			}	
		}
		return val;
	}
	
	public String setProperty(String name) {
		if(!map.containsKey(name)) {
			return null;
		}
		return map.get(name);
	}

	
	

	public static void main(String[] args) {
		
		
	}

}
