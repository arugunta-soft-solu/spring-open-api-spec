package ca.arugsoft.openapispec;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Puttaiah Arugunta
 *
 */
@RestController
@RequestMapping("/api")
public class RustController {
	Map<String, String> data = new HashMap<>();

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public String postCall(@RequestBody Data input) {

		String key = input.getKey();
		String value = input.getValue();
		data.put(key, value);
		System.out.println(data.get(key));
		if (data.containsKey(key)) {
			return ("Added Or Updated Key " + key + " Value:" + value);
		} else {
			return "Can't be added. It's duplicate!!! ";
		}

	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public Map<String, String> getAllCall() {
		return data;

	}

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public Data getValue(@PathVariable final String key) {
		String value = data.get(key);
		if (null != value) {
			return new Data(key, value);
		} else {
			return new Data();
		}

	}
}

/**
 * A class to hold data
 * 
 * @author 
 *
 */
class Data {
	String key;
	String value;

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
